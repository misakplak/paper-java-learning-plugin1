package cz.misakplak.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventPriority;


public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)

    public void onJoin(PlayerJoinEvent event) {

        event.setJoinMessage(null);


        Player player = event.getPlayer();

        event.getPlayer().sendMessage(
                PaperPlugin.getInstance()
                        .getConfig()
                        .getString("join-message")
        );
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeave(PlayerQuitEvent event) {

        event.setQuitMessage(null);

        event.getPlayer().sendMessage(
                PaperPlugin.getInstance()
                .getConfig()
                .getString("leave-message")
                );
    }
}