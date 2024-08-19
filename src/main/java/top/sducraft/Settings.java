package top.sducraft;

import carpet.api.settings.Rule;

public class Settings {
    public static final String sdu= "SDU";
    public static final String sdu3rd= "SDU_3RD";
    public static final String blocksdu= "BLOCK_SDU";

    @Rule(categories = {sdu,sdu3rd})
    public static boolean skipCropLightCheck = false;

    @Rule(categories = {sdu,sdu3rd})
    public static boolean brittleDeepSlate = false;

    @Rule(categories = {sdu,blocksdu})
    public static boolean notebookIgnoreupdate = false;

    @Rule(categories = {sdu,blocksdu})
    public static boolean noFallingBlock = false;

    @Rule(categories = {sdu,blocksdu})
    public static boolean blockPlaceIgnoreCondition = false;

    @Rule(categories = {sdu,blocksdu})
    public static boolean disablenoteboxinteraction = false;

}
