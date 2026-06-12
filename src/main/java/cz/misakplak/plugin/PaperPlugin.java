package cz.misakplak.plugin;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;


public final class PaperPlugin extends JavaPlugin {

    private static PaperPlugin instance;

    private Location pos1;
    private Location pos2;

    private HashMap<Location, BlockState> arenaBlocks = new HashMap<>();

    public HashMap<Location, BlockState> getArenaBlocks() {
        return arenaBlocks;
    }

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(
                new BlockListener(),
                this
        );

        getCommand("misakplak").setExecutor(new MainCommand());
        getCommand("misakplak").setTabCompleter(new MainTabCompleter());

        getCommand("heal").setExecutor(new HealCommand());

        getCommand("gmc").setExecutor(new GMcreative());
        getCommand("gms").setExecutor(new GMsurvival());
        getCommand("gmsp").setExecutor(new GMspectator());
        getCommand("gma").setExecutor(new GMadventure());

        getCommand("fly").setExecutor(new Flycommand());

        getCommand("announce").setExecutor(new AnnounceCommand());

        getCommand("savearena1").setExecutor(new SaveArena1Command());
        getCommand("savearena2").setExecutor(new SaveArena2Command());
        getCommand("arenainfo").setExecutor(new ArenaInfoCommand());
        getCommand("blockcount").setExecutor(new BlockCounter());
        getCommand("savearena").setExecutor(new SaveArenaCommand());
        getCommand("resetarena").setExecutor(new ResetArena());

        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static PaperPlugin getInstance() {
        return instance;
    }

    public void setPos1(Location pos1) {
        this.pos1 = pos1;
    }

    public Location getPos1() {
        return pos1;
    }

    public void setPos2(Location pos2) {
        this.pos2 = pos2;
    }

    public Location getPos2() {
        return pos2;
    }
}