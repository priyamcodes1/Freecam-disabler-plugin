package me.priyam.holycontrol.freeze;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.Location;

public class FreezeListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!HolyControl.FREEZE_ENABLED) return;
        Location f = e.getFrom(), t = e.getTo();
        t.setX(f.getX());
        t.setY(f.getY());
        t.setZ(f.getZ());
        e.setTo(t);
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
