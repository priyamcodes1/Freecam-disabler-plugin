package me.priyam.holycontrol;

import me.priyam.holycontrol.commands.HolyFreezeCommand;
import me.priyam.holycontrol.commands.PvPCommand;
import me.priyam.holycontrol.commands.ToggleTabCompleter;
import me.priyam.holycontrol.config.ConfigManager;
import me.priyam.holycontrol.freecam.FreecamDetector;
import me.priyam.holycontrol.freeze.FreezeListener;
import me.priyam.holycontrol.pvp.PvPListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HolyControl extends JavaPlugin {

    public static boolean PVP_ENABLED = true;
    public static boolean FREEZE_ENABLED = false;

    private ConfigManager config;

    @Override
    public void onEnable() {
        this.config = new ConfigManager(this);

        getServer().getPluginManager().registerEvents(new FreecamDetector(this), this);
        getServer().getPluginManager().registerEvents(new PvPListener(), this);
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);

        getCommand("pvp").setExecutor(new PvPCommand(this));
        getCommand("holyfreeze").setExecutor(new HolyFreezeCommand(this));

        getCommand("pvp").setTabCompleter(new ToggleTabCompleter());
        getCommand("holyfreeze").setTabCompleter(new ToggleTabCompleter());
    }

    public ConfigManager getConfigManager() {
        return config;
    }
}
