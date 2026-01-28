package me.priyam.holycontrol.pvp;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!HolyControl.PVP_ENABLED) {
            event.setCancelled(true);
        }
    }
}
