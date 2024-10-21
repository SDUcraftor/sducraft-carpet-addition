package top.sducraft;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.server.ServerTickCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.sducraft.config.loadConfig;
import top.sducraft.helpers.rule.fakePeaceHelper.fakePeaceHelper;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import static carpet.utils.Translations.getTranslationFromResourcePath;
import static top.sducraft.helpers.commands.easyFakePeace.easyFakePeaceCommandHelper.showFakePeaceStatus;
import static top.sducraft.helpers.commands.tickRateChangeMessage.tickRateChangeMessageCommandHelper.sendTickRateChangeMessage;
import static top.sducraft.helpers.rule.joinMessage.joinMessage.showJoinMessage;
import static top.sducraft.helpers.rule.joinMessage.tips.showtips;


public class SDUcraftCarpetAdditionMod implements CarpetExtension, ModInitializer {
    public static String MOD_ID = "SDU-carpet";
    public final static Logger LOGGER = LogManager.getLogger(MOD_ID);

    static {
        CarpetServer.manageExtension(new SDUcraftCarpetAdditionMod());
    }

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(loadConfig::load);
        ServerLifecycleEvents.SERVER_STARTED.register(fakePeaceHelper::loadChunkOnInitialize);
        ServerTickEvents.START_SERVER_TICK.register(fakePeaceHelper::onServerTick);
        top.sducraft.commands.commandregister.registerCommands();
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            showJoinMessage(handler.getPlayer());
        });
    }

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(SDUcraftCarpetSettings.class);
        LOGGER.info("[SDU] Mod Loaded.");
    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        Map<String, String> langdict = getTranslationFromResourcePath(String.format("assets/sdu/lang/%s.json", lang));
        if (langdict == null)
            langdict = getTranslationFromResourcePath("assets/sdu/lang/en_us.json");
        return langdict;
    }
}
