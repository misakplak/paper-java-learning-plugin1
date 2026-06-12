package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.block.BlockState;

public class ResetArena implements CommandExecutor {

    //----------------------------------ResetArena------------------------------------------

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!sender.hasPermission("misakplak.resetarena")) {
            sender.sendMessage("§c§lYou don't have permission!");
            return true;
        }


            for (BlockState state : PaperPlugin.getInstance().getArenaBlocks().values()) {
                state.update(true, false);
            }

            sender.sendMessage("§a§lArena has been reset!");
            return true;

    }
}