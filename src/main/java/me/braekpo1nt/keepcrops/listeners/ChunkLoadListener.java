package me.braekpo1nt.keepcrops.listeners;

import me.braekpo1nt.keepcrops.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkLoadListener implements Listener {
    
    public ChunkLoadListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        Bukkit.getLogger().info("Chunk " + event.getChunk() + " unloaded");
    }
    
}
