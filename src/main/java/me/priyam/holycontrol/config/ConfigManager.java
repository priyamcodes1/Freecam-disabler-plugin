package me.priyam.holycontrol.config;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    public static boolean FREECAM_ENABLED;
    public static int JOIN_DELAY;
    public static String KICK_MESSAGE;
    public static String BYPASS_PERMISSION;

    public static void load(JavaPlugin plugin) {
        FREECAM_ENABLED = plugin.getConfig().getBoolean("freecam.enabled");
        JOIN_DELAY = plugin.getConfig().getInt("freecam.join-delay-ticks");
        KICK_MESSAGE = plugin.getConfig().getString("freecam.kick-message");
        BYPASS_PERMISSION = plugin.getConfig().getString("freecam.bypass-permission");
    }
}
