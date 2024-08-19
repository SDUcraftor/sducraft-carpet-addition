package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(FaceAttachedHorizontalDirectionalBlock.class)
public abstract class FaceAttachedHorizontalDirectionalBlockMixin extends HorizontalDirectionalBlock {
    protected FaceAttachedHorizontalDirectionalBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "canSurvive",at=@At("HEAD"), cancellable = true)
    protected void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir){
        if(Settings.blockPlaceIgnoreCondition) {
            cir.setReturnValue(true);
        }
    }
}
