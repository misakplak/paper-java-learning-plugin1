package cz.misakplak.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnounceCommand implements CommandExecutor {

    //----------------------------------AnnounceCommand------------------------------------------

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!sender.hasPermission("misakplak.announce")) {
            sender.sendMessage(ChatColor.RED + "§c§lYou don't have permission!");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("§c§lUsage: /announce <message>");
            return true;
        }

        String message = String.join(" ", args);
        message = ChatColor.translateAlternateColorCodes('&', message);
       for  (Player p : Bukkit.getOnlinePlayers()) {
        p.sendActionBar(
                message);
       }


        return true;
    }
}