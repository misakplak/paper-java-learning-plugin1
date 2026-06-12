package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMcreative implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (!sender.hasPermission("gm.c")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            return true;
        }

        Player player = (Player) sender;

        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage("§a§lYour GameMode has been set to Creative!");

        return true;
    }
}