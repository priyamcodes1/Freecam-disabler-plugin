package me.priyam.holycontrol.commands;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.command.*;

public class HolyFreezeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
        if (a.length != 1) return false;
        HolyControl.FREEZE_ENABLED = a[0].equalsIgnoreCase("on");
        s.sendMessage("Freeze is now " + (HolyControl.FREEZE_ENABLED ? "ON" : "OFF"));
        return true;
    }
}
