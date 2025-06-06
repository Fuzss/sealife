package fuzs.sealife.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractLanguageProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.sealife.SeaLife;
import fuzs.sealife.init.*;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.Objects;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.addCreativeModeTab(ModRegistry.CREATIVE_MODE_TAB, SeaLife.MOD_NAME);
        translationBuilder.addBlock(ModBlocks.FISH_TRAP, "Fish Trap");
        translationBuilder.addBlock(ModBlocks.HATCHERY, "Hatchery");
        translationBuilder.addItem(ModItems.FISH_BONES, "Fish Bones");
        translationBuilder.addItem(ModItems.OLD_BOOT, "Old Boot");
        translationBuilder.addItem(ModItems.EMPTY_CAN, "Empty Can");
        translationBuilder.addItem(ModItems.FISH_FOSSIL, "Fish Fossil");
        translationBuilder.addItem(ModItems.PIRATE_TREASURE, "Pirate Treasure");
        translationBuilder.addItem(ModItems.FISH_FINGERS, "Fish Fingers");
        translationBuilder.addItem(ModItems.SASHIMI, "Sashimi");
        translationBuilder.addItem(ModItems.FISH_STEW, "Fish Stew");
        translationBuilder.addItem(ModItems.ANCHOVY, "Anchovy");
        translationBuilder.addItem(ModItems.ANGELFISH, "Angelfish");
        translationBuilder.addItem(ModItems.ANGLERFISH, "Anglerfish");
        translationBuilder.addItem(ModItems.BASS, "Bass");
        translationBuilder.addItem(ModItems.BLUE_TANG, "Blue Tang");
        translationBuilder.addItem(ModItems.BOWFIN, "Bowfin");
        translationBuilder.addItem(ModItems.BUTTERFLYFISH, "Butterflyfish");
        translationBuilder.addItem(ModItems.CARP, "Carp");
        translationBuilder.addItem(ModItems.CATFISH, "Catfish");
        translationBuilder.addItem(ModItems.CHUB, "Chub");
        translationBuilder.addItem(ModItems.DAMSELFISH, "Damselfish");
        translationBuilder.addItem(ModItems.ELECTRIC_RAY, "Electric Ray");
        translationBuilder.addItem(ModItems.GOLDFISH, "Goldfish");
        translationBuilder.addItem(ModItems.KOI, "Koi");
        translationBuilder.addItem(ModItems.LAMPREY, "Lamprey");
        translationBuilder.addItem(ModItems.LUNGFISH, "Lungfish");
        translationBuilder.addItem(ModItems.MANTA_RAY, "Manta Ray");
        translationBuilder.addItem(ModItems.MINNOW, "Minnow");
        translationBuilder.addItem(ModItems.NEON_TETRA, "Neon Tetra");
        translationBuilder.addItem(ModItems.NORTHERN_PIKE, "Northern Pike");
        translationBuilder.addItem(ModItems.PERCH, "Perch");
        translationBuilder.addItem(ModItems.PICKEREL, "Pickerel");
        translationBuilder.addItem(ModItems.PIRANHA, "Piranha");
        translationBuilder.addItem(ModItems.PUPFISH, "Pupfish");
        translationBuilder.addItem(ModItems.SARDINE, "Sardine");
        translationBuilder.addItem(ModItems.SIAMESE_FIGHTING_FISH, "Siamese Fighting Fish");
        translationBuilder.addItem(ModItems.SILVER_STRIPE_BLAASOP, "Silver-Stripe Blaasop");
        translationBuilder.addItem(ModItems.WHITEMARGIN_STARGAZER, "Whitemargin Stargazer");
        translationBuilder.addItem(ModItems.STINGRAY, "Stingray");
        translationBuilder.addItem(ModItems.TROUT, "Trout");
        translationBuilder.addItem(ModItems.TUNA, "Tuna");
        translationBuilder.addItem(ModItems.WALLEYE, "Walleye");
        translationBuilder.addItem(ModItems.ANCHOVY_BUCKET, "Bucket of Anchovy");
        translationBuilder.addItem(ModItems.ANGELFISH_BUCKET, "Bucket of Angelfish");
        translationBuilder.addItem(ModItems.ANGLERFISH_BUCKET, "Bucket of Anglerfish");
        translationBuilder.addItem(ModItems.BASS_BUCKET, "Bucket of Bass");
        translationBuilder.addItem(ModItems.BLUE_TANG_BUCKET, "Bucket of Blue Tang");
        translationBuilder.addItem(ModItems.BOWFIN_BUCKET, "Bucket of Bowfin");
        translationBuilder.addItem(ModItems.BUTTERFLYFISH_BUCKET, "Bucket of Butterflyfish");
        translationBuilder.addItem(ModItems.CARP_BUCKET, "Bucket of Carp");
        translationBuilder.addItem(ModItems.CATFISH_BUCKET, "Bucket of Catfish");
        translationBuilder.addItem(ModItems.CHUB_BUCKET, "Bucket of Chub");
        translationBuilder.addItem(ModItems.DAMSELFISH_BUCKET, "Bucket of Damselfish");
        translationBuilder.addItem(ModItems.ELECTRIC_RAY_BUCKET, "Bucket of Electric Ray");
        translationBuilder.addItem(ModItems.GOLDFISH_BUCKET, "Bucket of Goldfish");
        translationBuilder.addItem(ModItems.KOI_BUCKET, "Bucket of Koi");
        translationBuilder.addItem(ModItems.LAMPREY_BUCKET, "Bucket of Lamprey");
        translationBuilder.addItem(ModItems.LUNGFISH_BUCKET, "Bucket of Lungfish");
        translationBuilder.addItem(ModItems.MANTA_RAY_BUCKET, "Bucket of Manta Ray");
        translationBuilder.addItem(ModItems.MINNOW_BUCKET, "Bucket of Minnow");
        translationBuilder.addItem(ModItems.NEON_TETRA_BUCKET, "Bucket of Neon Tetra");
        translationBuilder.addItem(ModItems.NORTHERN_PIKE_BUCKET, "Bucket of Northern Pike");
        translationBuilder.addItem(ModItems.PERCH_BUCKET, "Bucket of Perch");
        translationBuilder.addItem(ModItems.PICKEREL_BUCKET, "Bucket of Pickerel");
        translationBuilder.addItem(ModItems.PIRANHA_BUCKET, "Bucket of Piranha");
        translationBuilder.addItem(ModItems.PUPFISH_BUCKET, "Bucket of Pupfish");
        translationBuilder.addItem(ModItems.SARDINE_BUCKET, "Bucket of Sardine");
        translationBuilder.addItem(ModItems.SIAMESE_FIGHTING_FISH_BUCKET, "Bucket of Siamese Fighting Fish");
        translationBuilder.addItem(ModItems.SILVER_STRIPE_BLAASOP_BUCKET, "Bucket of Silver-Stripe Blaasop");
        translationBuilder.addItem(ModItems.WHITEMARGIN_STARGAZER_BUCKET, "Bucket of Whitemargin Stargazer");
        translationBuilder.addItem(ModItems.STINGRAY_BUCKET, "Bucket of Stingray");
        translationBuilder.addItem(ModItems.TROUT_BUCKET, "Bucket of Trout");
        translationBuilder.addItem(ModItems.TUNA_BUCKET, "Bucket of Tuna");
        translationBuilder.addItem(ModItems.WALLEYE_BUCKET, "Bucket of Walleye");
        translationBuilder.addItem(ModItems.ANCHOVY_SPAWN_EGG, "Anchovy Spawn Egg");
        translationBuilder.addItem(ModItems.ANGELFISH_SPAWN_EGG, "Angelfish Spawn Egg");
        translationBuilder.addItem(ModItems.ANGLERFISH_SPAWN_EGG, "Anglerfish Spawn Egg");
        translationBuilder.addItem(ModItems.BASS_SPAWN_EGG, "Bass Spawn Egg");
        translationBuilder.addItem(ModItems.BLUE_TANG_SPAWN_EGG, "Blue Tang Spawn Egg");
        translationBuilder.addItem(ModItems.BOWFIN_SPAWN_EGG, "Bowfin Spawn Egg");
        translationBuilder.addItem(ModItems.BUTTERFLYFISH_SPAWN_EGG, "Butterflyfish Spawn Egg");
        translationBuilder.addItem(ModItems.CARP_SPAWN_EGG, "Carp Spawn Egg");
        translationBuilder.addItem(ModItems.CATFISH_SPAWN_EGG, "Catfish Spawn Egg");
        translationBuilder.addItem(ModItems.CHUB_SPAWN_EGG, "Chub Spawn Egg");
        translationBuilder.addItem(ModItems.DAMSELFISH_SPAWN_EGG, "Damselfish Spawn Egg");
        translationBuilder.addItem(ModItems.ELECTRIC_RAY_SPAWN_EGG, "Electric Ray Spawn Egg");
        translationBuilder.addItem(ModItems.GOLDFISH_SPAWN_EGG, "Goldfish Spawn Egg");
        translationBuilder.addItem(ModItems.KOI_SPAWN_EGG, "Koi Spawn Egg");
        translationBuilder.addItem(ModItems.LAMPREY_SPAWN_EGG, "Lamprey Spawn Egg");
        translationBuilder.addItem(ModItems.LUNGFISH_SPAWN_EGG, "Lungfish Spawn Egg");
        translationBuilder.addItem(ModItems.MANTA_RAY_SPAWN_EGG, "Manta Ray Spawn Egg");
        translationBuilder.addItem(ModItems.MINNOW_SPAWN_EGG, "Minnow Spawn Egg");
        translationBuilder.addItem(ModItems.NEON_TETRA_SPAWN_EGG, "Neon Tetra Spawn Egg");
        translationBuilder.addItem(ModItems.NORTHERN_PIKE_SPAWN_EGG, "Northern Pike Spawn Egg");
        translationBuilder.addItem(ModItems.PERCH_SPAWN_EGG, "Perch Spawn Egg");
        translationBuilder.addItem(ModItems.PICKEREL_SPAWN_EGG, "Pickerel Spawn Egg");
        translationBuilder.addItem(ModItems.PIRANHA_SPAWN_EGG, "Piranha Spawn Egg");
        translationBuilder.addItem(ModItems.PUPFISH_SPAWN_EGG, "Pupfish Spawn Egg");
        translationBuilder.addItem(ModItems.SARDINE_SPAWN_EGG, "Sardine Spawn Egg");
        translationBuilder.addItem(ModItems.SIAMESE_FIGHTING_FISH_SPAWN_EGG, "Siamese Fighting Fish Spawn Egg");
        translationBuilder.addItem(ModItems.SILVER_STRIPE_BLAASOP_SPAWN_EGG, "Silver-Stripe Blaasop Spawn Egg");
        translationBuilder.addItem(ModItems.WHITEMARGIN_STARGAZER_SPAWN_EGG, "Whitemargin Stargazer Spawn Egg");
        translationBuilder.addItem(ModItems.STINGRAY_SPAWN_EGG, "Stingray Spawn Egg");
        translationBuilder.addItem(ModItems.TROUT_SPAWN_EGG, "Trout Spawn Egg");
        translationBuilder.addItem(ModItems.TUNA_SPAWN_EGG, "Tuna Spawn Egg");
        translationBuilder.addItem(ModItems.WALLEYE_SPAWN_EGG, "Walleye Spawn Egg");
        addEntityType(translationBuilder, ModEntityTypes.ANCHOVY, "Anchovy");
        addEntityType(translationBuilder, ModEntityTypes.ANGELFISH, "Angelfish");
        addEntityType(translationBuilder, ModEntityTypes.ANGLERFISH, "Anglerfish");
        addEntityType(translationBuilder, ModEntityTypes.BASS, "Bass");
        addEntityType(translationBuilder, ModEntityTypes.BLUE_TANG, "Blue Tang");
        addEntityType(translationBuilder, ModEntityTypes.BOWFIN, "Bowfin");
        addEntityType(translationBuilder, ModEntityTypes.BUTTERFLYFISH, "Butterflyfish");
        addEntityType(translationBuilder, ModEntityTypes.CARP, "Carp");
        addEntityType(translationBuilder, ModEntityTypes.CATFISH, "Catfish");
        addEntityType(translationBuilder, ModEntityTypes.CHUB, "Chub");
        addEntityType(translationBuilder, ModEntityTypes.DAMSELFISH, "Damselfish");
        addEntityType(translationBuilder, ModEntityTypes.ELECTRIC_RAY, "Electric Ray");
        addEntityType(translationBuilder, ModEntityTypes.GOLDFISH, "Goldfish");
        addEntityType(translationBuilder, ModEntityTypes.KOI, "Koi");
        addEntityType(translationBuilder, ModEntityTypes.LAMPREY, "Lamprey");
        addEntityType(translationBuilder, ModEntityTypes.LUNGFISH, "Lungfish");
        addEntityType(translationBuilder, ModEntityTypes.MANTA_RAY, "Manta Ray");
        addEntityType(translationBuilder, ModEntityTypes.MINNOW, "Minnow");
        addEntityType(translationBuilder, ModEntityTypes.NEON_TETRA, "Neon Tetra");
        addEntityType(translationBuilder, ModEntityTypes.NORTHERN_PIKE, "Northern Pike");
        addEntityType(translationBuilder, ModEntityTypes.PERCH, "Perch");
        addEntityType(translationBuilder, ModEntityTypes.PICKEREL, "Pickerel");
        addEntityType(translationBuilder, ModEntityTypes.PIRANHA, "Piranha");
        addEntityType(translationBuilder, ModEntityTypes.PUPFISH, "Pupfish");
        addEntityType(translationBuilder, ModEntityTypes.SARDINE, "Sardine");
        addEntityType(translationBuilder, ModEntityTypes.SIAMESE_FIGHTING_FISH, "Siamese Fighting Fish");
        addEntityType(translationBuilder, ModEntityTypes.SILVER_STRIPE_BLAASOP, "Silver-Stripe Blaasop");
        addEntityType(translationBuilder, ModEntityTypes.STINGRAY, "Stingray");
        addEntityType(translationBuilder, ModEntityTypes.TROUT, "Trout");
        addEntityType(translationBuilder, ModEntityTypes.TUNA, "Tuna");
        addEntityType(translationBuilder, ModEntityTypes.WALLEYE, "Walleye");
        addEntityType(translationBuilder, ModEntityTypes.WHITEMARGIN_STARGAZER, "Whitemargin Stargazer");
        addPaintingVariant(translationBuilder, ModPaintingVariants.ALBATROSS, "Albatross", "Joshiejack");
        addPaintingVariant(translationBuilder, ModPaintingVariants.BOATS, "Boats", "Joshiejack");
        addPaintingVariant(translationBuilder, ModPaintingVariants.LIGHTHOUSE, "Lighthouse", "Joshiejack");
        addPaintingVariant(translationBuilder, ModPaintingVariants.SUNSET, "Sunset", "Joshiejack");
        addPaintingVariant(translationBuilder, ModPaintingVariants.WINDOW, "Window", "Joshiejack");
    }

    @Deprecated
    static void addEntityType(TranslationBuilder translationBuilder, Holder<? extends EntityType<?>> entityType, String value) {
        translationBuilder.add(entityType.value(), value);
    }

    @Deprecated
    static void addPaintingVariant(TranslationBuilder translationBuilder, ResourceKey<PaintingVariant> paintingVariant, String title, String author) {
        Objects.requireNonNull(paintingVariant, "painting variant is null");
        translationBuilder.add(paintingVariant.location().toLanguageKey("painting", "title"), title);
        translationBuilder.add(paintingVariant.location().toLanguageKey("painting", "author"), author);
    }
}
