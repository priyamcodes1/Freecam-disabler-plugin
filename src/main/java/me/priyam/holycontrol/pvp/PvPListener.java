package me.priyam.holycontrol.pvp;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;

public class PvPListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        if (!HolyControl.PVP_ENABLED) e.setCancelled(true);
    }
}
