package org.dbenton.timestop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class ClockInteractListener implements Listener {

    private boolean isFrozen = false;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Ensure we're handling right-clicks
        if (event.getAction().toString().contains("RIGHT_CLICK")) {
            // Check if the hand being used is the main hand
            if (event.getHand() == EquipmentSlot.HAND) {
                ItemStack item = event.getItem();
                if (item != null && item.getType() == Material.CLOCK) {
                    if (isFrozen) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tick unfreeze");
                        sendMessage(event.getPlayer(), "&6&lTime unfrozen!");
                    } else {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tick freeze");
                        sendMessage(event.getPlayer(), "&6&lTime stopped!");
                    }
                    isFrozen = !isFrozen;  // Toggle the state
                }
            }
        }
    }

    private void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
