package me.otherone.campfire.yml;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static File file;
    private static FileConfiguration configFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CampfireEffects").getDataFolder(), "config.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                //UH-OH
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return configFile;
    }

    public static void save() {
        try {
            configFile.save(file);
        } catch (IOException e) {
            System.out.println("Cant save config.yml file for some reason.");
        }
    }

    public static void reload() {
        configFile = YamlConfiguration.loadConfiguration(file);
    }
}
