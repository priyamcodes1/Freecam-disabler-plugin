package me.priyam.holycontrol.freecam;

import me.priyam.holycontrol.HolyControl;
import me.priyam.holycontrol.config.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FreecamDetector implements Listener {

    private final ConfigManager config;

    public FreecamDetector(HolyControl plugin) {
        this.config = plugin.getConfigManager();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String name = event.getPlayer().getName();

        if (!config.isFreecamAllowed()) return;
        if (config.isBypassed(name)) return;

        // kick instantly (translation-key exploit trigger)
        event.getPlayer().kick(config.getKickMessage());
    }
}
