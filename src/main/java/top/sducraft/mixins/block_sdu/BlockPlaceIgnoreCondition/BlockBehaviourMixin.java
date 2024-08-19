package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.Reference2ObjectArrayMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateHolder;
import net.minecraft.world.level.block.state.properties.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockBehaviourMixin  extends StateHolder<Block, BlockState> {
    protected BlockBehaviourMixin(Block object, Reference2ObjectArrayMap<Property<?>, Comparable<?>> reference2ObjectArrayMap, MapCodec<BlockState> mapCodec) {super(object, reference2ObjectArrayMap, mapCodec);}

    @Inject(method = "canSurvive",at=@At("HEAD"), cancellable = true)
    public void canSurvive(LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition) {
            cir.setReturnValue(true);
        }
        }
}
