package cz.misakplak.plugin;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;
import org.bukkit.block.BlockState;

public class SaveArenaCommand implements CommandExecutor {

    //----------------------------------savearena------------------------------------------

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!sender.hasPermission("misakplak.savearena")) {
            sender.sendMessage(ChatColor.RED + "§c§lYou don't have permission!");
            return true;
        }



            Location pos1 = PaperPlugin.getInstance().getPos1();
            Location pos2 = PaperPlugin.getInstance().getPos2();

        if (pos1 == null || pos2 == null) {
            sender.sendMessage("§cSet arena positions first!");
            return true;
        }

            int minX = Math.min(pos1.getBlockX(), pos2.getBlockX());
            int maxX = Math.max(pos1.getBlockX(), pos2.getBlockX());

            int minY = Math.min(pos1.getBlockY(), pos2.getBlockY());
            int maxY = Math.max(pos1.getBlockY(), pos2.getBlockY());

            int minZ = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
            int maxZ = Math.max(pos1.getBlockZ(), pos2.getBlockZ());


        PaperPlugin.getInstance().getArenaBlocks().clear();



            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    for (int z = minZ; z <= maxZ; z++) {

                        Block block = pos1.getWorld().getBlockAt(x, y, z);



                        PaperPlugin.getInstance().getArenaBlocks().put(
                                block.getLocation(),
                                block.getState()
                        );


                    }
                }
            }

            sender.sendMessage("§a§lArena has been saved!");
        return true;
    }
}