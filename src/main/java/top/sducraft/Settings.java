package top.sducraft;

import carpet.api.settings.Rule;

public class Settings {
    public static final String sdu= "SDU";

    @Rule(
            categories = {sdu}
    )
    public static boolean skipCropLightCheck = false;

    @Rule(
            categories = {sdu}
    )
    public static boolean brittleDeepSlate = false;
    @Rule(
            categories = {sdu}
    )
    public static boolean notebookIgnoreupdate = false;
    @Rule(
            categories = {sdu}
    )
    public static boolean noFallingBlock = false;
}
