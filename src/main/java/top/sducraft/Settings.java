package top.sducraft;

import carpet.api.settings.Rule;
import carpet.api.settings.Validators;

public class Settings {
    public static final String sdu3rd= "SDU_3RD";
    public static final String blocksdu= "BLOCK_SDU";

    @Rule(categories = {sdu3rd})
    public static boolean skipCropLightCheck = false;

    @Rule(categories = {sdu3rd})
    public static boolean brittleDeepSlate = false;

    @Rule(categories = {blocksdu})
    public static boolean notebookIgnoreupdate = false;

    @Rule(categories = {blocksdu})
    public static boolean noFallingBlock = false;

    @Rule(categories = {blocksdu})
    public static boolean blockPlaceIgnoreCondition = false;

    @Rule(categories = {blocksdu})
    public static boolean disablenoteboxinteraction = false;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            options = {"0", "40", "80", "32767"},
            strict = false,
            categories = {blocksdu}
    )
    public static int itempickupdelay = 40;

}
