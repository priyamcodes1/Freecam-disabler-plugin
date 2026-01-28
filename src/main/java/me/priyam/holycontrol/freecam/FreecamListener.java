package me.priyam.holycontrol.freecam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;

public class FreecamListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (!p.isOnline()) return;

        // Ignore head rotation
        if (e.getFrom().getX() == e.getTo().getX()
         && e.getFrom().getZ() == e.getTo().getZ()) return;

        double dist = e.getFrom().distance(e.getTo());

        // Impossible vanilla movement (Freecam signature)
        if (dist > 12 && !p.isFlying() && !p.getAllowFlight()) {
            p.kick(Component.text("Freecam is not allowed"));
        }
    }
}
