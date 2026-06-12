package cz.misakplak.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BasicCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§c§lOnly players can execute this command!");
            return true;
        }

        switch (command.getName().toLowerCase()) {

            //-----------------------RegenCommand---------------------------------

            case "regen" -> {
                if (!sender.hasPermission("misakplak.heal")) {
                    sender.sendMessage("§c§lNo permission!");
                    return true;
                }
                if (args.length == 0) {
                    sender.sendMessage("§cUsage: /regen <player>");
                    return true;
                }

                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage("§cPlayer not found!");
                    return true;
                }

                target.setHealth(20);
                target.setFoodLevel(20);
                target.setSaturation(20);
                target.setExhaustion(0);
                target.sendMessage("§a§lYou have been regened!");
                sender.sendMessage("§aRegened §f" + target.getName() + "§a!");
            }

            //-----------------------FlyCommand---------------------------------

            case "fly" -> {
                if (player.getGameMode() == GameMode.CREATIVE
                        || player.getGameMode() == GameMode.SPECTATOR) {
                    player.sendMessage("§cFly is automatic in this gamemode!");
                    return true;
                }
                if (!player.hasPermission("misakplak.fly")) {
                    player.sendMessage("§c§lNo permission!");
                    return true;
                }

                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage("§c§lFly disabled.");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage("§a§lFly enabled!");
                }
            }

        }

        return true;
    }
}