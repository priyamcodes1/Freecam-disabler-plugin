package me.priyam.holycontrol;

import org.bukkit.plugin.java.JavaPlugin;
import me.priyam.holycontrol.freecam.FreecamListener;
import me.priyam.holycontrol.freeze.FreezeListener;
import me.priyam.holycontrol.pvp.PvPListener;

public final class HolyControl extends JavaPlugin {

    public static boolean PVP_ENABLED = true;
    public static boolean FREEZE_ENABLED = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FreecamListener(), this);
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);
        getServer().getPluginManager().registerEvents(new PvPListener(), this);

        getCommand("pvp").setExecutor(new commands.PvPCommand());
        getCommand("holyfreeze").setExecutor(new commands.HolyFreezeCommand());
    }
}
