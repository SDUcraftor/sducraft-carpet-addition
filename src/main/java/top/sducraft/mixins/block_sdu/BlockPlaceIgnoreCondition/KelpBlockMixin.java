package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(KelpBlock.class)
public abstract class KelpBlockMixin extends GrowingPlantHeadBlock implements LiquidBlockContainer {
    protected KelpBlockMixin(Properties properties, Direction direction, VoxelShape voxelShape, boolean bl, double d) {super(properties, direction, voxelShape, bl, d);}

    @Inject(method = "canAttachTo",at=@At("HEAD"), cancellable = true)
    protected void canAttachTo(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }
    @Inject(method = "canGrowInto",at=@At("HEAD"), cancellable = true)
    protected void canGrowInto(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }
    @Inject(method = "getFluidState",at=@At("HEAD"), cancellable = true)
    protected void getFluidState(BlockState blockState, CallbackInfoReturnable<FluidState> cir) {
        cir.setReturnValue(blockState.getFluidState());
    }
}
