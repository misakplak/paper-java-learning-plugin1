package cz.misakplak.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class SaveArena1Command implements CommandExecutor {

    //----------------------------------Save1------------------------------------------

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;


        if (!sender.hasPermission("misakplak.savearena")) {
            sender.sendMessage("§c§lYou don't have permission!");
            return true;
        }

        if (!(sender instanceof  Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }


        PaperPlugin.getInstance().setPos1(player.getLocation());
        player.sendMessage("§a§lArena position 1 saved!");


        return true;
    }
}