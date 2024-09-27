package top.sducraft.commands.tickRateChangedMessageCommand;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

import static net.minecraft.commands.Commands.argument;

public class tickRateChangeMessageCommand {
    public static void register(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("leavemassage")
                .then(argument("string",StringArgumentType.greedyString())
                .executes((commandContext) -> {
                    tickRateChangeMessageCommandHelper.tickRateChangeMessage=StringArgumentType.getString(commandContext, "string");
                    ServerPlayer player = commandContext.getSource().getPlayerOrException();
                    tickRateChangeMessageCommandHelper.playername = player.getName().getString();
                    if(Objects.equals(tickRateChangeMessageCommandHelper.tickRateChangeMessage, "clear")){
                        tickRateChangeMessageCommandHelper.resetTickRateChangeMessage();
                    }
                    return 0;
                })));
    }
}
