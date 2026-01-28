package me.priyam.holycontrol;

import me.priyam.holycontrol.config.ConfigManager;
import me.priyam.holycontrol.freecam.FreecamDetector;
import org.bukkit.plugin.java.JavaPlugin;

public class HolyControl extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        getServer().getPluginManager().registerEvents(
                new FreecamDetector(this, configManager), this
        );
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
