package me.priyam.holycontrol.freeze;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.Location;

public class FreezeListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!HolyControl.FREEZE_ENABLED) return;

        Location from = e.getFrom();
        Location to = e.getTo();

        to.setX(from.getX());
        to.setY(from.getY());
        to.setZ(from.getZ());
        e.setTo(to);
    }

    @EventHandler public void onBreak(BlockBreakEvent e) {
        if (HolyControl.FREEZE_ENABLED) e.setCancelled(true);
    }

    @EventHandler public void onPlace(BlockPlaceEvent e) {
        if (HolyControl.FREEZE_ENABLED) e.setCancelled(true);
    }

    @EventHandler public void onInteract(PlayerInteractEvent e) {
        if (HolyControl.FREEZE_ENABLED) e.setCancelled(true);
    }
}
