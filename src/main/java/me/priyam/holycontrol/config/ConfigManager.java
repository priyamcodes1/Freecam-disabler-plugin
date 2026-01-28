package me.priyam.holycontrol.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private final JavaPlugin plugin;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    public String getActorName() {
        return plugin.getConfig().getString("messages.actor-name", "Console");
    }

    public Component getMessage(String path) {
        String msg = plugin.getConfig().getString(path, "");
        msg = msg.replace("<actor>", getActorName());
        return mm.deserialize(msg);
    }
}
