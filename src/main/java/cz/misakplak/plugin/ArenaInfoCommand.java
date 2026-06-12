package cz.misakplak.plugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaInfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;

        Location pos1 = PaperPlugin.getInstance().getPos1();
        Location pos2 = PaperPlugin.getInstance().getPos2();


        if (pos1 == null || pos2 == null) {
            sender.sendMessage("§c§lThere is no arena saved!");
            return true;
        }

        player.sendMessage("§8§m--------------------§r §a§lArena Info §8§m--------------------");
        player.sendMessage("§ePos1: §f" + pos1.getBlockX() + ", " + pos1.getBlockY() + ", " + pos1.getBlockZ());
        player.sendMessage("§ePos2: §f" + pos2.getBlockX() + ", " + pos2.getBlockY() + ", " + pos2.getBlockZ());
        player.sendMessage("");
        player.sendMessage("§bWidth: §f" + Math.abs(pos1.getBlockX() - pos2.getBlockX()));
        player.sendMessage("§bHeight: §f" + Math.abs(pos1.getBlockY() - pos2.getBlockY()));
        player.sendMessage("§bDepth: §f" + Math.abs(pos1.getBlockZ() - pos2.getBlockZ()));
        player.sendMessage("§8§m------------------------------------------------");

        return true;
    }
}