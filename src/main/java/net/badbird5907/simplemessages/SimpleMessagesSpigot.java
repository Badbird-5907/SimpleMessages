package net.badbird5907.simplemessages;

import net.badbird5907.blib.bLib;
import net.badbird5907.simplemessages.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleMessagesSpigot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        bLib.create(this);
        bLib.getCommandFramework().registerCommandsInPackage("net.badbird5907.simplemessages.commands");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerManager.join(e.getPlayer());
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        PlayerManager.leave(e.getPlayer());
    }
}
