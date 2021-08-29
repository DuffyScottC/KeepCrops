package me.braekpo1nt.keepcrops.data;

import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.Set;

/**
 * Holds a chunk, and a list of 
 */
public class CropChunk {
    
    private Chunk chunk;
    private Set<Location> crops;
    
    public CropChunk(Chunk chunk) {
        this.chunk = chunk;
    }
    
}
