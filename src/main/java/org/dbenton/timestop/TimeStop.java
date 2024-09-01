package org.dbenton.timestop;

import org.bukkit.plugin.java.JavaPlugin;

public class TimeStop extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ClockInteractListener(), this);
        getLogger().info("TimeStop has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TimeStop has been disabled!");
    }
}
