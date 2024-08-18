package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(BushBlock.class)
public abstract class BushBlockMixin  extends Block {

    public BushBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "mayPlaceOn",at=@At("HEAD"), cancellable = true)
    protected void mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (Settings.saplingPlaceIgnoreCondition) {
            cir.setReturnValue(true);
        }
    }
}
