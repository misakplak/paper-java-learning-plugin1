package cz.misakplak.plugin;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.entity.Player;


public class BlockListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPermission("misakplak.break")) {
            event.setCancelled(true);

            player.sendMessage(
                    PaperPlugin.getInstance()
                            .getConfig()
                    .getString("blockbreakmessage")
            );

            return;
        }


    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPermission("misakplak.place")) {
            event.setCancelled(true);

            player.sendMessage(
                    PaperPlugin.getInstance()
                            .getConfig()
                            .getString("blockplacemessage")
            );
            return;
        }
    }
}
