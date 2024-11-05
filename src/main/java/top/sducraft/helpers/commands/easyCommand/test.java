package top.sducraft.helpers.commands.easyCommand;

import net.minecraft.network.chat.Component;
import top.sducraft.config.rule.easyCommandConfig;
import top.sducraft.util.massageComponentCreate;

import java.awt.*;
import java.util.Comparator;

public class test {

    public static Component generateCommandComponent() {

        Component component =  Component.empty();

        for (easyCommandConfig.CommandData commandData : easyCommandConfig.commandDataList.stream()
                .sorted(Comparator.comparingInt(c -> c.id))
                .toList()) {
            Component commandComponent = massageComponentCreate.createCommandClickComponent(
                    "[" + commandData.label + "] ",
                    "/easycommand " + commandData.id,
                    commandData.hoverText
            );
            component = Component.empty().append(component).append(commandComponent);
        }

        return component;
    }
}