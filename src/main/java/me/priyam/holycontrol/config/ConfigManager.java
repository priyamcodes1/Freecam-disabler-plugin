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
    private final MiniMessage mm = MiniMessage.miniMessage();

    private FileConfiguration bypassConfig;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadBypass();
    }

    private void loadBypass() {
        File file = new File(plugin.getDataFolder(), "bypass.yml");
        if (!file.exists()) {
            plugin.saveResource("bypass.yml", false);
        }
        bypassConfig = YamlConfiguration.loadConfiguration(file);
    }

    /* ---------- FREECAM ---------- */

    public boolean isFreecamAllowed() {
        return plugin.getConfig().getBoolean("freecam.enabled", true);
    }

    public boolean isBypassed(String playerName) {
        List<String> list = bypassConfig.getStringList("players");
        return list.stream().anyMatch(p -> p.equalsIgnoreCase(playerName));
    }

    public Component getKickMessage() {
        return mm.deserialize(
                plugin.getConfig().getString(
                        "freecam.kick-message",
                        "<red>Freecam is not allowed</red>"
                )
        );
    }

    /* ---------- MESSAGES ---------- */

    public String getActorName() {
        return plugin.getConfig().getString("messages.actor-name", "Console");
    }

    public Component getMessage(String path) {
        String msg = plugin.getConfig().getString(path, "");
        msg = msg.replace("<actor>", getActorName());
        return mm.deserialize(msg);
    }
}
