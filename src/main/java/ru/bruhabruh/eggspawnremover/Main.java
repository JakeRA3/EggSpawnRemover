package ru.bruhabruh.eggspawnremover;

import org.bukkit.Bukkit;
import org.bukkit.entity.Chicken;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import java.util.logging.Logger;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Logger logger = Bukkit.getLogger();
        try {
            Bukkit.getPluginManager().registerEvents(this, this);
            logger.info("Plugin is enabled!");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.warning("Plugin getting error!");
        }
    }

    @Override
    public void onDisable() {
        Logger logger = Bukkit.getLogger();
        logger.info("Plugin is disabled!");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChickenSpawn(CreatureSpawnEvent event) {
        if (!(event.getEntity() instanceof Chicken)) { return; }
        if (!event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.EGG)) { return; }
        event.setCancelled(true);
    }
}
