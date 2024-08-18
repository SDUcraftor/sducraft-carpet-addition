package top.sducraft.mixins.block_sdu;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(FallingBlock.class)
public abstract class FallingBlockMixin extends Block implements Fallable {
    public FallingBlockMixin(Properties properties) {
        super(properties);
    }
//禁用掉落方块生成
    @Inject(method = "isFree",at=@At("HEAD"), cancellable = true)
    private static void isFree(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.noFallingBlock){
        cir.setReturnValue(false);
         }
    }
}

