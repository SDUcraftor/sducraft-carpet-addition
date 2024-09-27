package top.sducraft.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import top.sducraft.commands.tickRateChangedMessageCommand.tickRateChangeMessageCommand;

public class commandregister {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> tickRateChangeMessageCommand.register(dispatcher)));
    }
}
