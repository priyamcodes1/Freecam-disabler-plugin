package me.priyam.holycontrol.commands;

import org.bukkit.command.*;
import java.util.List;

public class ToggleTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender s, Command c, String a, String[] args) {
        return args.length == 1 ? List.of("on", "off") : List.of();
    }
}
