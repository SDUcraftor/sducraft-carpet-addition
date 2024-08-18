package top.sducraft.mixins.SDUcraft3RD;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviorMixin implements FeatureElement {
    @Shadow
    protected abstract Block asBlock();

    @Inject(method = "getDestroyProgress", at = @At("TAIL"), cancellable = true)
    public void getDestroyProgress(BlockState blockState, Player player, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Float> cir) {
        if (Settings.brittleDeepSlate) {
            if (this.asBlock() == Blocks.DEEPSLATE) {
                cir.setReturnValue(1.6F);
            }
        }

    }
}




