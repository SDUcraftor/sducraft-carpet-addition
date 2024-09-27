package top.sducraft.mixins.command.tickRateChangerMessageCommand;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTickRateManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.sducraft.commands.tickRateChangedMessageCommand.tickRateChangeMessageCommandHelper;



@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Inject(method = "onTickRateChanged", at = @At("HEAD"))
    private void onTickRateChanged(CallbackInfo info) {
        MinecraftServer server = ((MinecraftServer) (Object) this);
        PlayerList playerList = server.getPlayerList();
        ServerTickRateManager tickRateManager = server.tickRateManager();

        //游戏速度正常时重置留言
        if(tickRateManager.tickrate() == 20&&!tickRateManager.isFrozen()&&!tickRateManager.isSprinting()){
            tickRateChangeMessageCommandHelper.resetTickRateChangeMessage();
        }
        else{
            for (ServerPlayer player : playerList.getPlayers()) {
                if (player != null) {
                    player.displayClientMessage(Component.literal("检测到游戏速度发生改变，可以使用 ").append(Component.literal("/leavemessage").withStyle(ChatFormatting.AQUA)).append(" 指令进行留言"), false);
                }
            }
        }
    }
}




