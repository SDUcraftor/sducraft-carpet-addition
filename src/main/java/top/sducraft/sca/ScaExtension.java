package top.sducraft.sca;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static carpet.utils.Translations.getTranslationFromResourcePath;

public class ScaExtension implements CarpetExtension, ModInitializer {
    public static String MOD_ID = "SCA";
    public final static Logger LOGGER = LogManager.getLogger(MOD_ID);

    static {
        CarpetServer.manageExtension(new ScaExtension());
    }

    @Override
    public void onInitialize() {
    }

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(ScaSettings.class);
        LOGGER.info("[SCA] Mod Loaded.");
    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        Map<String, String> langdict = getTranslationFromResourcePath(String.format("assets/sca/lang/%s.json", lang));
        if (langdict == null)
            langdict = getTranslationFromResourcePath("assets/sca/lang/en_us.json");
        return langdict;
    }
}
