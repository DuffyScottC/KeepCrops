package me.braekpo1nt.keepcrops.commands;

import me.braekpo1nt.keepcrops.Main;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeepCropsCommand implements CommandExecutor {
    
    public KeepCropsCommand(Main plugin) {
        plugin.getCommand("keepcrops").setExecutor(this);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Chunk chunk = player.getLocation().getChunk();
            
            if (Main.containsChunk(chunk)) {
                player.sendMessage("duplicate chunk");
                return true;
            }
            
            Main.addChunk(chunk);
            player.sendMessage("Successfully added " + chunk);
            return true;
        }
        
        return false;
    }
}
