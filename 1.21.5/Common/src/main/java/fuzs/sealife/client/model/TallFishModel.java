package fuzs.sealife.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class TallFishModel extends FishModel<LivingEntityRenderState> {

    public TallFishModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create()
                        .texOffs(4, 2)
                        .addBox(0.0F, 0.0F, 1.0F, 0.0F, 4.0F, 1.0F)
                        .texOffs(2, 4)
                        .addBox(0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 1.0F)
                        .texOffs(0, 4)
                        .addBox(0.0F, 3.0F, 2.0F, 0.0F, 1.0F, 1.0F)
                        .texOffs(0, 1)
                        .addBox(0.0F, 1.0F, -1.0F, 0.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 20.0F, 4.0F));

        partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.0F, -4.0F, -3.0F, 2.0F, 4.0F, 7.0F)
                        .texOffs(0, 0)
                        .addBox(-1.0F, -3.0F, -4.0F, 2.0F, 2.0F, 1.0F)
                        .texOffs(0, 8)
                        .addBox(0.0F, -5.0F, -2.0F, 0.0F, 1.0F, 4.0F)
                        .texOffs(0, 7)
                        .addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 32, 16);
    }
}