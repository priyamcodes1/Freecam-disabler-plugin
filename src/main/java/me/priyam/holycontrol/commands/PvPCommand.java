package me.priyam.holycontrol.commands;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.command.*;

public class PvPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
        if (a.length != 1) return false;
        HolyControl.PVP_ENABLED = a[0].equalsIgnoreCase("on");
        s.sendMessage("PvP is now " + (HolyControl.PVP_ENABLED ? "ON" : "OFF"));
        return true;
    }
}
