package me.priyam.holycontrol.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ConfigManager {

    private final JavaPlugin plugin;
    private List<String> bypassList;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;

        plugin.saveDefaultConfig();
        plugin.saveResource("bypass.yml", false);

        reload();
    }

    public void reload() {
        plugin.reloadConfig();
        bypassList = plugin.getConfig()
                .getStringList("freecam-bypass-placeholder"); // dummy init

        bypassList = plugin.getServer()
                .getPluginManager()
                .getPlugin(plugin.getName())
                .getConfig()
                .getStringList("freecam-bypass-placeholder");
    }

    public boolean isFreecamAllowed() {
        return plugin.getConfig().getBoolean("freecam.allow", false);
    }

    public boolean isBypassed(String playerName) {
        return plugin.getConfig()
                .getStringList("freecam-bypass-placeholder")
                .contains(playerName);
    }

    public Component getKickMessage() {
        String msg = plugin.getConfig()
                .getString("freecam.kick-message");
        return MiniMessage.miniMessage().deserialize(msg);
    }
}
