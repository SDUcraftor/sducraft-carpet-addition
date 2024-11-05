package top.sducraft.helpers.commands.easyCommand;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class easyPerpetualDayEasyCommand {
    public static void showEasyPerpetualDayInterface(ServerPlayer player) {
        player.displayClientMessage(Component.literal("这个功能还没写好喵,如果想参与模组开发请联系xhbsh"), false);
    }
}
