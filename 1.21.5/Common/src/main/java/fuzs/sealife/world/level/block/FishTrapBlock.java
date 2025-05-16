package fuzs.sealife.world.level.block;

import com.mojang.serialization.MapCodec;
import fuzs.sealife.init.ModLootTables;
import fuzs.sealife.init.ModRegistry;
import fuzs.sealife.world.level.block.entity.FishTrapBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class FishTrapBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<FishTrapBlock> CODEC = simpleCodec(FishTrapBlock::new);
    public static final List<BlockPos> WATER_OFFSETS = BlockPos.withinManhattanStream(BlockPos.ZERO, 1, 1, 1)
            .filter((BlockPos blockPos) -> blockPos.distManhattan(BlockPos.ZERO) == 1)
            .map(BlockPos::immutable)
            .toList();
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    public static final BooleanProperty BAITED = BooleanProperty.create("baited");

    public FishTrapBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(STAGE, 0)
                .setValue(BAITED, Boolean.FALSE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, bl);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(WATERLOGGED);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(5) == 0 && isSurroundedByWater(serverLevel, blockPos)) {
            if (blockState.getValue(STAGE) == 0) {
                serverLevel.setBlock(blockPos, blockState.cycle(STAGE), 260);
            } else {
                if (serverLevel.getBlockEntity(blockPos) instanceof FishTrapBlockEntity blockEntity &&
                        blockEntity.isBaited()) {
                    LootParams lootParams = new LootParams.Builder(serverLevel).withParameter(LootContextParams.ORIGIN,
                                    Vec3.atCenterOf(blockPos))
                            .withParameter(LootContextParams.TOOL, blockEntity.getItem(0))
                            .create(LootContextParamSets.FISHING);
                    LootTable lootTable = serverLevel.getServer()
                            .reloadableRegistries()
                            .getLootTable(ModLootTables.FISH_TRAP);
                    List<ItemStack> list = lootTable.getRandomItems(lootParams);
                    ItemStack itemStack = list.isEmpty() ? ItemStack.EMPTY : list.getFirst();
                    blockEntity.setItem(0, itemStack);
                }
            }
        }
    }

    static boolean isSurroundedByWater(Level level, BlockPos blockPos) {
        int waterOnSides = 0;
        for (BlockPos offsetPos : WATER_OFFSETS) {
            if (level.getFluidState(blockPos.offset(offsetPos)).is(FluidTags.WATER)) {
                waterOnSides++;
            }
        }
        return waterOnSides >= 5;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof FishTrapBlockEntity blockEntity) {
            if (blockEntity.getItem(0).isEmpty() && stack.is(ModRegistry.FISHING_BAIT_ITEM_TAG)) {
                if (!level.isClientSide()) {
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    blockEntity.setItem(0, stack.consumeAndReturn(1, player));
                    level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                return InteractionResult.SUCCESS;
            } else {
                return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof FishTrapBlockEntity blockEntity) {
            if (!blockEntity.getItem(0).isEmpty() && !blockEntity.isBaited()) {
                if (!level.isClientSide()) {
                    ItemStack itemStack = blockEntity.removeItem(0, 1);
                    level.playSound(null, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!player.getInventory().add(itemStack)) {
                        player.drop(itemStack, false);
                    }

                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                    if (level.getRandom().nextInt(4) == 0) {
                        level.destroyBlock(pos, false);
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                return super.useWithoutItem(state, level, pos, player, hitResult);
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FishTrapBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, STAGE, BAITED);
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }
}
