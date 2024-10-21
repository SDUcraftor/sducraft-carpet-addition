package top.sducraft.helpers.rule.joinMessage;

import net.minecraft.server.level.ServerPlayer;
import java.util.Timer;
import java.util.TimerTask;
import static top.sducraft.helpers.commands.easyFakePeace.easyFakePeaceCommandHelper.showFakePeaceStatus;
import static top.sducraft.helpers.commands.tickRateChangeMessage.tickRateChangeMessageCommandHelper.sendTickRateChangeMessage;
import static top.sducraft.helpers.rule.joinMessage.tips.showtips;

public abstract class joinMessage {
    public static void showJoinMessage(ServerPlayer player) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendTickRateChangeMessage(player);
                showtips(player);
                showFakePeaceStatus(player);
                timer.cancel();}}, 500);
    }

}
