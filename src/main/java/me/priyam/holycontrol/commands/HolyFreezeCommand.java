package me.priyam.holycontrol.commands;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HolyFreezeCommand implements CommandExecutor {

    private final HolyControl plugin;

    public HolyFreezeCommand(HolyControl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) return false;

        if (args[0].equalsIgnoreCase("on")) {
            HolyControl.FREEZE_ENABLED = true;
            plugin.getServer().broadcast(
                    plugin.getConfigManager().getMessage("holyfreeze.enabled-message")
            );
        }

        if (args[0].equalsIgnoreCase("off")) {
            HolyControl.FREEZE_ENABLED = false;
            plugin.getServer().broadcast(
                    plugin.getConfigManager().getMessage("holyfreeze.disabled-message")
            );
        }
        return true;
    }
}
