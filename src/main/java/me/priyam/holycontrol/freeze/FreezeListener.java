package me.priyam.holycontrol.freeze;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (HolyControl.FREEZE_ENABLED) {
            if (event.getFrom().getX() != event.getTo().getX()
                    || event.getFrom().getZ() != event.getTo().getZ()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (HolyControl.FREEZE_ENABLED) event.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (HolyControl.FREEZE_ENABLED) event.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (HolyControl.FREEZE_ENABLED) event.setCancelled(true);
    }
}
