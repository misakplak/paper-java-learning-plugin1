package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flycommand implements CommandExecutor {

    //----------------------------------flyCommand------------------------------------------
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (((Player) sender).getGameMode() == GameMode.CREATIVE
                || GameMode.SPECTATOR == ((Player) sender).getGameMode()) {
            return true;
        }

        if (!sender.hasPermission("misakplak.fly")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }


        Player player = (Player) sender;

        if (((Player) sender).getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.GREEN + "You are not flying anymore.");
        }
        else {
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You are flying!");

        }


        return true;
    }
}