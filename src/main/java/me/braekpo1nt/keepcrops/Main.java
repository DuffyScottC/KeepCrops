package me.braekpo1nt.keepcrops;

import me.braekpo1nt.keepcrops.commands.KeepCropsCommand;
import me.braekpo1nt.keepcrops.listeners.ChunkLoadListener;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {
    
    private static final List<Chunk> chunks = new ArrayList<>();
    
    public static void addChunk(Chunk chunk) {
        chunks.add(chunk);
    }
    
    public static boolean containsChunk(Chunk chunk) {
        return chunks.contains(chunk);
    }
    
    @Override
    public void onEnable() {
        new ChunkLoadListener(this);
        
        new KeepCropsCommand(this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Chunk chunk : chunks) {
                    for (Player player : getServer().getOnlinePlayers()) {
                        // if there is a player within 128 blocks of the center of this chunk
                        if (dist(chunk.getX() * 16, chunk.getZ() * 16, player.getLocation().getBlockX(), player.getLocation().getBlockZ()) < 128) {
                            return;
                        }
                    }
                    Bukkit.getLogger().info("Chunk " + chunk + " is not in 128 blocks of player");
                }
                
            }
        }, 0L, 20/*ticks*/ * 5L/*seconds*/);
    }
    
    private int dist(int x1, int z1, int x2, int z2) {
        return (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(z1 - z2, 2));
    }
    
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
