package me.priyam.holycontrol.commands;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HolyFreezeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) return false;

        if (args[0].equalsIgnoreCase("on")) {
            HolyControl.FREEZE_ENABLED = true;
            sender.sendMessage("All players frozen");
        } else if (args[0].equalsIgnoreCase("off")) {
            HolyControl.FREEZE_ENABLED = false;
            sender.sendMessage("Freeze disabled");
        }

        return true;
    }
}
