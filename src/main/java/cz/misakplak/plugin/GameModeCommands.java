package cz.misakplak.plugin;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§c§lOnly players can execute this command!");
            return true;
        }

        switch (command.getName().toLowerCase()) {

            //-----------------------Survival---------------------------------

            case "gms" -> {

                if (!player.hasPermission("gm.s")) {
                    player.sendMessage("§c§lNo permission!");
                    return true;
                }

                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§a§lYour GameMode has been set to Survival!");
            }

            //-----------------------Creative---------------------------------

            case "gmc" -> {

                if (!player.hasPermission("gm.c")) {
                    player.sendMessage("§c§lNo permission!");
                    return true;
                }

                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§a§lYour GameMode has been set to Creative!");
            }

            //-----------------------Spectator---------------------------------

            case "gmsp" -> {

                if (!player.hasPermission("gm.sp")) {
                    sender.sendMessage("§c§lNo permission!");
                    return true;
                }
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§a§lYour GameMode has been set to Spectator!");
            }

            //-----------------------Adventure---------------------------------

            case "gma" -> {

                if (!player.hasPermission("gm.a")) {
                    player.sendMessage("§c§lNo permission!");
                    return true;
                }

                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§a§lYour GameMode has been set to Adventure!");
            }
        }


        return true;
    }
}



