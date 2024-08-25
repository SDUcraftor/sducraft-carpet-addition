//package top.sducraft.mixins.block_sdu;
//
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.TraceableEntity;
//import net.minecraft.world.entity.item.ItemEntity;
//import net.minecraft.world.level.Level;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import top.sducraft.Settings;
//
//@Mixin(ItemEntity.class)
//public abstract class ItemEntityMixin  extends Entity implements TraceableEntity {
//    @Shadow private int pickupDelay;
//
//    public ItemEntityMixin(EntityType<?> entityType, Level level) {super(entityType, level);}
//
//    @Inject(method = "setPickUpDelay",at=@At("HEAD"), cancellable = true)
//    private void setPickUpDelay(int i, CallbackInfo ci) {
//        this.pickupDelay= Settings.itempickupdelay;
//        ci.cancel();
//    }
//
//}
