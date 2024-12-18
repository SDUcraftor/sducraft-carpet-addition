package top.sducraft.commands.easyCommand;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import top.sducraft.SDUcraftCarpetSettings;
import static top.sducraft.helpers.commands.easyCommand.fakepeaceEasyCommand.showFakeEasyCommandInterface;
import static top.sducraft.helpers.commands.easyCommand.easyCommandHelper.showEasyCommandInterface;
import static top.sducraft.helpers.commands.easyCommand.easyPerpetualDayEasyCommand.showEasyPerpetualDayInterface;
import static top.sducraft.helpers.commands.easyCommand.locEasyCommand.showLocInterface;
import static top.sducraft.helpers.commands.easyCommand.mirrorManageEasyCommand.showMirrorInterface;
import static top.sducraft.helpers.commands.easyCommand.spectatorEasyCommand.showSpectatorInterface;
import static top.sducraft.helpers.commands.easyCommand.tickRateManagerEasyCommand.showTickRateManagerInterface;

public class easycommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("easycommand")
                .requires(c -> SDUcraftCarpetSettings.easyCommand)
                .executes(context -> {
                    showEasyCommandInterface((context.getSource().getPlayer()));
                    return 1;
                })
                .then(Commands.argument("int", IntegerArgumentType.integer())
                        .executes(context -> {
                            int i = IntegerArgumentType.getInteger(context, "int");
                            ServerPlayer player =context.getSource().getPlayer();
                            switch (i) {
                                case 1 -> showFakeEasyCommandInterface(player);
                                case 2 -> showEasyPerpetualDayInterface(player);
                                case 3 -> showLocInterface(player);
                                case 4 -> showMirrorInterface(player);
                                case 5 -> showTickRateManagerInterface(player);
                                case 6 -> showSpectatorInterface(player);
                            }
                            return 1;
                        })
                ));
    }
}

