package cz.misakplak.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
        Bukkit.broadcastMessage("§3" + player.getName() + "§a§l Joined the game");
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeave(PlayerQuitEvent event) {

        event.setQuitMessage(null);

        Player player =  event.getPlayer();

        Bukkit.broadcastMessage("§3" + player.getName() + "§a§l Left the game");
    }
}