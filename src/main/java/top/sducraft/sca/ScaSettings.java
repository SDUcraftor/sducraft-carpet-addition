package top.sducraft.sca;

import carpet.api.settings.Rule;

public class ScaSettings {
    public static final String SCA = "SCA";

    @Rule(
            categories = {SCA}
    )
    public static boolean skipCropLightCheck = false;
}
