package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(Block.class)
public abstract class BlockMixin extends BlockBehaviour implements ItemLike, FabricBlock {
    public BlockMixin(Properties properties) {super(properties);}

    @Inject(method ="canSupportCenter",at=@At("HEAD"), cancellable = true)
    private static void canSupportCenter(LevelReader levelReader, BlockPos blockPos, Direction direction, CallbackInfoReturnable<Boolean> cir){
        if(Settings.blockPlaceIgnoreCondition){
             cir.setReturnValue(true);
        }
}
}
