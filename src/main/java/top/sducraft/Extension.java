package top.sducraft;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static carpet.utils.Translations.getTranslationFromResourcePath;

public class Extension implements CarpetExtension, ModInitializer {
    public static String MOD_ID = "SDU-carpet";
    public final static Logger LOGGER = LogManager.getLogger(MOD_ID);

    static {
        CarpetServer.manageExtension(new Extension());
    }

    @Override
    public void onInitialize() {
    }

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(Settings.class);
        LOGGER.info("[SDU] Mod Loaded.");
    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        Map<String, String> langdict = getTranslationFromResourcePath(String.format("assets/sca/lang/%s.json", lang));
        if (langdict == null)
            langdict = getTranslationFromResourcePath("assets/sca/lang/en_us.json");
        return langdict;
    }
}
