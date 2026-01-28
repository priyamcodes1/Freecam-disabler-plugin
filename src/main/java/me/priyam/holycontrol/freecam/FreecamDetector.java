package me.priyam.holycontrol.freecam;

import me.priyam.holycontrol.HolyControl;
import me.priyam.holycontrol.config.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FreecamDetector implements Listener {

    private final HolyControl plugin;
    private final ConfigManager config;

    public FreecamDetector(HolyControl plugin, ConfigManager config) {
        this.plugin = plugin;
        this.config = config;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // bypass list
        if (config.isBypassed(player.getName())) return;

        if (!config.isFreecamAllowed()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.kick(config.getKickMessage());
                }
            }.runTaskLater(plugin, 1L);
        }
    }
}
