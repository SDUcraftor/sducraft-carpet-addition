package top.sducraft.helpers.commands.easyCommand;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import top.sducraft.util.massageComponentCreate;

import static top.sducraft.helpers.commands.easyCommand.test.generateCommandComponent;

public class easyCommandHelper {
    public static void showEasyCommandInterface(ServerPlayer player) {
        Component component1 = Component.literal("\n欢迎使用sducrafr快捷命令系统,以下消息中所有[]按钮均可点击\n")
                .append(massageComponentCreate.createCommandClickComponent("[伪和平] ", "/easycommand 1","点击进入伪和平控制界面"))
                .append(massageComponentCreate.createCommandClickComponent("[永昼机] ", "/easycommand 2","点击进入永昼机控制界面"))
                .append(massageComponentCreate.createCommandClickComponent("[服务器路标] ", "/easycommand 3","点击进入服务器路标界面"))
                .append(massageComponentCreate.createCommandClickComponent("[镜像服管理] ", "/easycommand 4","点击进入镜像服管理界面"))
                .append(massageComponentCreate.createCommandClickComponent("[游戏速度控制] ", "/easycommand 5","点击进入游戏界面控制界面"))
                .append(massageComponentCreate.createCommandClickComponent("[旁观者模式]","/easycommand 6",null));
        Component component2 =generateCommandComponent();
        player.displayClientMessage(component1, false);
    }
}
