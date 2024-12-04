package top.sducraft.mixins.rule.tntTeleportThroughNetherPortal;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.sducraft.SDUcraftCarpetSettings;

@Mixin(PrimedTnt.class)
public abstract class primedTntMixin extends Entity implements TraceableEntity {
    public primedTntMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }
    @Inject(method = "tick",at=@At("HEAD"))
    private void tick(CallbackInfo ci) {
        if(SDUcraftCarpetSettings.tntTeleportThroughNetherPortal) {
            this.handleNetherPortal();
        }
    }
}

