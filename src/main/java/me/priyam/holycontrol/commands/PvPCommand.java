package me.priyam.holycontrol.commands;

import me.priyam.holycontrol.HolyControl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PvPCommand implements CommandExecutor {

    private final HolyControl plugin;

    public PvPCommand(HolyControl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) return false;

        if (args[0].equalsIgnoreCase("on")) {
            HolyControl.PVP_ENABLED = true;
            plugin.getServer().broadcast(
                    plugin.getConfigManager().getMessage("pvp.enabled-message")
            );
        }

        if (args[0].equalsIgnoreCase("off")) {
            HolyControl.PVP_ENABLED = false;
            plugin.getServer().broadcast(
                    plugin.getConfigManager().getMessage("pvp.disabled-message")
            );
        }
        return true;
    }
}
