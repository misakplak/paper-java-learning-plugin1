package cz.misakplak.plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage("§cUsage: /heal <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage("§c§lPlayer not found!");
            return true;
        }

        target.setHealth(20);

        sender.sendMessage("§aHealed " + target.getName() + "!");
        target.sendMessage("§a§lYou have been healed!");

        return true;
    }
}