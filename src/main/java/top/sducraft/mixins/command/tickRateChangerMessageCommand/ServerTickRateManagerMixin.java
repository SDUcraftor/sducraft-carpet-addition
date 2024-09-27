package top.sducraft.mixins.command.tickRateChangerMessageCommand;

import net.minecraft.server.ServerTickRateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerTickRateManager.class)
public abstract class ServerTickRateManagerMixin {
    @Shadow public abstract void setTickRate(float f);

    @Inject(method = "requestGameToSprint",at=@At("HEAD"))
    private void RequestGameToSprint(int i, CallbackInfoReturnable<Boolean> cir) {
        this.setTickRate(20.0F);
    }

    @Inject(method = "setFrozen",at=@At("HEAD"))
    private void setFrozen(boolean bl, CallbackInfo ci) {
        this.setTickRate(20.0F);
    }
}
