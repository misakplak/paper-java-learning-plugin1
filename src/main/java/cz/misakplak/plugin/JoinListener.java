package cz.misakplak.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinListener implements Listener {

    @EventHandler

    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        player.sendMessage(
                PaperPlugin.getInstance()
                        .getConfig()
                        .getString("join-message")
        );
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        Bukkit.broadcastMessage(player.getName(
        ) +
                PaperPlugin.getInstance()
                .getConfig()
                .getString("leave-message")
                );

    }
}