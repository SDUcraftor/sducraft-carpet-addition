package top.sducraft.mixins.rule.pearlLoadChunk;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.sducraft.helpers.rule.chunkLoadHelper.RegistTicket;

@Mixin(ThrownEnderpearl.class)
public abstract class thrownEnderPearlMixin extends ThrowableItemProjectile {

    public thrownEnderPearlMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {super(entityType, level);}
//
//    @Unique
//    private long ticketTimer = 0L;
//
//
//    @Inject(method = "tick",at = @At("HEAD"))
//    private void tick(CallbackInfo ci) {
//        int i = SectionPos.blockToSectionCoord(this.position().x());
//        int j = SectionPos.blockToSectionCoord(this.position().z());
//        BlockPos blockPos = BlockPos.containing(this.position());
//        if ((--this.ticketTimer <= 0L || i != SectionPos.blockToSectionCoord(blockPos.getX()) || j != SectionPos.blockToSectionCoord(blockPos.getZ()))) {
//            this.ticketTimer = RegistTicket.addPearlTicket();
//        }
//    }
//

}
