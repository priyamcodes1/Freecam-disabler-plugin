package me.priyam.holycontrol.config;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private final JavaPlugin plugin;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    public boolean isFreecamAllowed() {
        return plugin.getConfig().getBoolean("freecam.allow", false);
    }

    public String getFreecamKickMessage() {
        return plugin.getConfig().getString(
                "freecam.kick-message",
                "Freecam is not allowed"
        );
    }
}
