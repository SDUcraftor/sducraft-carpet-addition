package top.sducraft.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin extends BushBlock {
    private CropBlockMixin(Properties properties) {
        super(properties);
    }

    // 移除种植时光照判断
    @Inject(method = "canSurvive", at = @At(value = "HEAD"), cancellable = true)
    private void canSurvive_RemoveLightCheck(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (Settings.skipCropLightCheck)
            cir.setReturnValue(super.canSurvive(blockState, levelReader, blockPos));
    }


    // 移除生长时光照判断
    @ModifyConstant(method = "randomTick",
            slice = @Slice(from = @At(value = "HEAD"), to = @At(value = "TAIL")),
            constant = @Constant(intValue = 9))
    private int randomTick_getRawBrightness_redirect(int instance) {
        if (Settings.skipCropLightCheck)
            return 0;
        return instance;
    }
}
