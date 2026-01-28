package me.priyam.holycontrol.freecam;

import net.kyori.adventure.text.Component;
import me.priyam.holycontrol.HolyControl;
import me.priyam.holycontrol.config.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FreecamDetector {

    private static final String TEST_KEY = "freecam.toggle";

    public static void register(HolyControl plugin) {
        ProtocolLibrary.getProtocolManager().addPacketListener(
            new PacketAdapter(plugin, ListenerPriority.HIGHEST,
                PacketType.Play.Server.SYSTEM_CHAT) {

                @Override
                public void onPacketSending(PacketEvent event) {
                    Player p = event.getPlayer();
                    if (p.hasPermission(ConfigManager.BYPASS_PERMISSION)) return;

                    Component c = event.getPacket().getChatComponents().read(0);
                    if (c == null) return;

                    if (c.toString().contains(TEST_KEY)) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                p.kick(Component.text(ConfigManager.KICK_MESSAGE));
                            }
                        }.runTask(plugin);
                    }
                }
            }
        );

        plugin.getServer().getPluginManager().registerEvents(
            new org.bukkit.event.Listener() {
                @org.bukkit.event.EventHandler
                public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
                    Player p = e.getPlayer();
                    plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
                        p.sendMessage(Component.translatable(TEST_KEY));
                    }, ConfigManager.JOIN_DELAY);
                }
            }, plugin
        );
    }
}
