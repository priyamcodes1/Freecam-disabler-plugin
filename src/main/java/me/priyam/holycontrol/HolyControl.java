package me.priyam.holycontrol;

import me.priyam.holycontrol.commands.HolyFreezeCommand;
import me.priyam.holycontrol.commands.PvPCommand;
import me.priyam.holycontrol.config.ConfigManager;
import me.priyam.holycontrol.freeze.FreezeListener;
import me.priyam.holycontrol.freecam.FreecamDetector;
import me.priyam.holycontrol.pvp.PvPListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HolyControl extends JavaPlugin {

    public static boolean PVP_ENABLED = true;
    public static boolean FREEZE_ENABLED = false;

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);

        getServer().getPluginManager().registerEvents(
                new FreecamDetector(this, configManager), this);
        getServer().getPluginManager().registerEvents(
                new PvPListener(), this);
        getServer().getPluginManager().registerEvents(
                new FreezeListener(), this);

        getCommand("pvp").setExecutor(new PvPCommand());
        getCommand("holyfreeze").setExecutor(new HolyFreezeCommand());
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
