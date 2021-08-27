package me.braekpo1nt.keepcrops;

import me.braekpo1nt.keepcrops.listeners.ChunkLoadListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new ChunkLoadListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
