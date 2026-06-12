package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMsurvival implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            return true;
        }

        if (!sender.hasPermission("gm.s")) {
            sender.sendMessage("§c§lYou don't have permission!");
            return true;
        }


        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage("§a§lYour GameMode has been set to Survival!");

        return true;
    }
}