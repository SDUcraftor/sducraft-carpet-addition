package top.sducraft;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import static carpet.utils.Translations.getTranslationFromResourcePath;
import static top.sducraft.commands.tickRateChangedMessageCommand.tickRateChangeMessageCommandHelper.sendmessage;


public class SDUcraftCarpetAdditionMod implements CarpetExtension, ModInitializer {
    public static String MOD_ID = "SDU-carpet";
    public final static Logger LOGGER = LogManager.getLogger(MOD_ID);

    static {
        CarpetServer.manageExtension(new SDUcraftCarpetAdditionMod());
    }

    @Override
    public void onInitialize() {
        top.sducraft.commands.commandregister.registerCommands();
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            sendmessage(handler.getPlayer());
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
