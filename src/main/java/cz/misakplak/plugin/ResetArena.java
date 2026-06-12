package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetArena implements CommandExecutor {

    //----------------------------------ResetArena------------------------------------------

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!sender.hasPermission("misakplak.resetarena")) {
            sender.sendMessage(ChatColor.RED + "§c§lYou don't have permission!");
            return true;
        }


        for (Location loc : PaperPlugin.getInstance().getArenaBlocks().keySet()) {
            Material material = PaperPlugin.getInstance().getArenaBlocks().get(loc);
            loc.getBlock().setType(material);
        }

        sender.sendMessage("§a§lArena has been reset!");
        return true;
    }
}