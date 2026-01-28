package me.priyam.holycontrol.commands;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PvPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) return false;

        if (args[0].equalsIgnoreCase("on")) {
            HolyControl.PVP_ENABLED = true;
            sender.sendMessage("PvP enabled");
        } else if (args[0].equalsIgnoreCase("off")) {
            HolyControl.PVP_ENABLED = false;
            sender.sendMessage("PvP disabled");
        }

        return true;
    }
}
