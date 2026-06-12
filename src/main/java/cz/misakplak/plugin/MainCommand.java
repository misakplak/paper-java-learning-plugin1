package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /misakplak reload");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {

            if (!sender.hasPermission("misakplak.reload")) {
                sender.sendMessage(ChatColor.RED + "No permission!");
                return true;
            }

            PaperPlugin.getInstance().reloadConfig();

            sender.sendMessage(ChatColor.GREEN + "Config reloaded!");
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Unknown subcommand!");
        return true;
    }
}