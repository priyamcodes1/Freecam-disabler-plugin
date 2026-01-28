package me.priyam.holycontrol.freecam;

import me.priyam.holycontrol.HolyControl;
import me.priyam.holycontrol.config.ConfigManager;
import net.kyori.adventure.text.Component;
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

        if (!config.isFreecamAllowed()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.kick(Component.text(config.getFreecamKickMessage()));
                }
            }.runTaskLater(plugin, 1L);
        }
    }
}
