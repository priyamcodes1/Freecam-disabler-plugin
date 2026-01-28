package me.priyam.holycontrol;

import org.bukkit.plugin.java.JavaPlugin;
import me.priyam.holycontrol.config.ConfigManager;
import me.priyam.holycontrol.freecam.FreecamDetector;
import me.priyam.holycontrol.freeze.FreezeListener;
import me.priyam.holycontrol.pvp.PvPListener;
import me.priyam.holycontrol.commands.*;

public final class HolyControl extends JavaPlugin {

    public static boolean PVP_ENABLED = true;
    public static boolean FREEZE_ENABLED = false;
    public static HolyControl INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        ConfigManager.load(this);

        // listeners
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);
        getServer().getPluginManager().registerEvents(new PvPListener(), this);

        // commands
        getCommand("pvp").setExecutor(new PvPCommand());
        getCommand("holyfreeze").setExecutor(new HolyFreezeCommand());
        getCommand("holycontrol").setExecutor(new ReloadCommand());

        ToggleTabCompleter tab = new ToggleTabCompleter();
        getCommand("pvp").setTabCompleter(tab);
        getCommand("holyfreeze").setTabCompleter(tab);

        // freecam detector
        if (ConfigManager.FREECAM_ENABLED) {
            FreecamDetector.register(this);
        }
    }
}
