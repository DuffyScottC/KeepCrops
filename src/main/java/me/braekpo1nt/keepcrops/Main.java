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
    
    @Override
    public void onEnable() {
        new ChunkLoadListener(this);
        
        new KeepCropsCommand(this);
    }
    
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
