package me.braekpo1nt.keepcrops.listeners;

import me.braekpo1nt.keepcrops.Main;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkLoadListener implements Listener {
    
    private Main plugin;
    
    public ChunkLoadListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    private void startClock() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Chunk chunk : chunks) {
                    for (Player player : plugin.getServer().getOnlinePlayers()) {
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
    
    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        Chunk chunk = event.getChunk();
        if (Main.containsChunk(chunk)) {
            Bukkit.getLogger().info("Kept Chunk " + chunk + " unloaded");
        }
    }
    
    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();
        if (Main.containsChunk(chunk)) {
            Bukkit.getLogger().info("Kept Chunk " + chunk + " unloaded");
        }
    }
    
}
