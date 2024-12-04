package top.sducraft.mixins.rule.disableNetherPortal;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.sducraft.SDUcraftCarpetSettings;

@Mixin(Entity.class)
public abstract class entityMIxin
{
    @Inject(method = "handleNetherPortal",at=@At("HEAD"), cancellable = true)
    protected void handleNetherPortal(CallbackInfo ci) {
        if(SDUcraftCarpetSettings.disableNetherPortal) {
            ci.cancel();
        }
    }
}
