package top.sducraft.config.rule;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelResource;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class easyCommandConfig {
    public static File configFile;
    public static List<CommandData> commandDataList = new ArrayList<>();

    public static class CommandData {
        public int id;
        public String label;           // 新增的label字段
        String description;
        String url;
        public String hoverText;
        String tips;
        List<ClickableEvent> clickableEvents;
    }

    static class ClickableEvent {
        String label;
        String command;
        String hoverText;

        public ClickableEvent(String label, String command, String hoverText) {
            this.label = label;
            this.command = command;
            this.hoverText = hoverText;
        }
    }

    // 初始化时加载配置
    public static void init(MinecraftServer server) {
        File worldDir = server.getWorldPath(LevelResource.ROOT).toFile();
        File configDir = new File(worldDir, "config");
        if (!configDir.exists()) {
            configDir.mkdirs();
        }
        configFile = new File(configDir, "easy_command_config.json");
        loadConfig();
    }

    // 加载配置文件
    private static void loadConfig() {
        try {
            if (configFile.exists()) {
                FileReader reader = new FileReader(configFile);
                Type type = new TypeToken<List<CommandData>>() {}.getType();
                commandDataList = new Gson().fromJson(reader, type);
                reader.close();
                System.out.println("Config loaded successfully: " + commandDataList); // 调试输出
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 保存配置文件
    public static void saveConfig() {
        try {
            FileWriter writer = new FileWriter(configFile);
            new GsonBuilder().setPrettyPrinting().create().toJson(commandDataList, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 根据 label 获取 CommandData
    public static CommandData getCommandDataByLabel(String label) {
        return commandDataList.stream()
                .filter(commandData -> commandData.label.equals(label))
                .findFirst()
                .orElse(null);
    }

    // 添加或更新 CommandData
    public static void setCommandData(CommandData commandData) {
        commandDataList.removeIf(existingData -> existingData.id == commandData.id);
        commandDataList.add(commandData);
        commandDataList.sort(Comparator.comparingInt(data -> data.id)); // 按 id 排序
        saveConfig();
    }
}
