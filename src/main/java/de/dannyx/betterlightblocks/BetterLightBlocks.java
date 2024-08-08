package de.dannyx.betterlightblocks;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class BetterLightBlocks extends JavaPlugin {

    public static FileConfiguration getPluginConfig() {
        File file = new File(String.valueOf(BetterLightBlocks.getPlugin(BetterLightBlocks.class).getDataFolder()), "config.yml");

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        return config;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new RightClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
