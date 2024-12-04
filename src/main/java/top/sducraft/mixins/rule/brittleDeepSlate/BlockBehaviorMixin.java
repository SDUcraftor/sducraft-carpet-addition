package top.sducraft.mixins.rule.brittleDeepSlate;

import net.minecraft.core.BlockPos;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.SDUcraftCarpetSettings;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockBehaviorMixin implements FeatureElement {

    @Shadow
    public abstract boolean is(Block block);

    @Inject(method = "getDestroySpeed", at = @At("TAIL"), cancellable = true)
    public void getDestroySpeed(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Float> cir) {
        if (SDUcraftCarpetSettings.brittleDeepSlate) {
            if (this.is(Blocks.DEEPSLATE)) {
                cir.setReturnValue(1.6F);
            }
        }

    }
}


