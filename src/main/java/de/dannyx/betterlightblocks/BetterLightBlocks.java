package de.dannyx.betterlightblocks;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class BetterLightBlocks extends JavaPlugin {
    public static String perm;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        perm = (String) config.get("permission-name");

        Bukkit.getPluginManager().registerEvents(new RightClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
