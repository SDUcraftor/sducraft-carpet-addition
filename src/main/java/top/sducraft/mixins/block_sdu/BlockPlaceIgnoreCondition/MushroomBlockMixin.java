package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(MushroomBlock.class)
public abstract class MushroomBlockMixin extends BushBlock implements BonemealableBlock {
    protected MushroomBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "mayPlaceOn",at=@At("HEAD"), cancellable = true)
    protected void mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition) {
            cir.setReturnValue(true);
        }
    }
    @Inject(method = "canSurvive",at=@At("HEAD"), cancellable = true)
    protected void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition) {
            cir.setReturnValue(true);
        }
    }
}
