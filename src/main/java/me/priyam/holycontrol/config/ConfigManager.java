package me.priyam.holycontrol.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class ConfigManager {

    private final JavaPlugin plugin;
    private File bypassFile;
    private FileConfiguration bypassConfig;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;

        plugin.saveDefaultConfig();
        setupBypassFile();
        reload();
    }

    private void setupBypassFile() {
        bypassFile = new File(plugin.getDataFolder(), "bypass.yml");
        if (!bypassFile.exists()) {
            plugin.saveResource("bypass.yml", false);
        }
        bypassConfig = YamlConfiguration.loadConfiguration(bypassFile);
    }

    public void reload() {
        plugin.reloadConfig();
        bypassConfig = YamlConfiguration.loadConfiguration(bypassFile);
    }

    // -------- FREECAM --------

    public boolean isFreecamAllowed() {
        return plugin.getConfig().getBoolean("freecam.allow", false);
    }

    public boolean isBypassed(String playerName) {
        List<String> list = bypassConfig.getStringList("freecam-bypass");
        return list.stream().anyMatch(name -> name.equalsIgnoreCase(playerName));
    }

    public Component getKickMessage() {
        String msg = plugin.getConfig().getString(
                "freecam.kick-message",
                "<red>Freecam is not allowed.</red>"
        );
        return MiniMessage.miniMessage().deserialize(msg);
    }
}
