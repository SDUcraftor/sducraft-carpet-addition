package top.sducraft;

import carpet.api.settings.CarpetRule;
import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
import carpet.utils.CommandHelper;
import net.minecraft.commands.CommandSourceStack;

public class SDUcraftCarpetSettings {
    public static final String sdu= "SDU";

    @Rule(categories = {sdu})
    public static boolean skipCropLightCheck = false;

    @Rule(categories = {sdu})
    public static boolean armorStandIgnoreShulkerDamage = false;


    @Rule(categories = {sdu})
    public static boolean brittleDeepSlate = false;

//    @Rule(categories = {sdu})
//    public static boolean tickRateChangedMessage = false;

    @Rule(  categories = {sdu},
            options = {"true", "false"},
            validators = {NotifyPlayers.class})
    public static boolean tickRateChangedMessage = false;

    @Rule(  categories = {sdu},
            options = {"true", "false"},
            validators = {NotifyPlayers.class})
    public static boolean easyFakePeace = false;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            options = {"0", "40", "80", "32767"},
            strict = false,
            categories = {sdu}
    )
    public static int itempickupdelay = 40;

    private static class NotifyPlayers extends Validator<Boolean> {
        @Override
        public Boolean validate(CommandSourceStack source, CarpetRule<Boolean> changingRule, Boolean newValue, String userInput) {
            if (source != null) {
                CommandHelper.notifyPlayersCommandsChanged(source.getServer());
            }
            return newValue;
        }
    }
}
