package me.otherone.campfire;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CampfireEvents implements Listener {

    @EventHandler
    public static void onPlayerDisconnect(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Utl.removeCampfirePlayer(player);
        Utl.removeSoulCampfirePlayer(player);
    }

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Utl.removeCampfirePlayer(player);
        Utl.removeSoulCampfirePlayer(player);
    }

    @EventHandler
    public static void playerDrinkMilk(PlayerItemConsumeEvent event) {
        if (event.getItem().getType().equals(Material.MILK_BUCKET)) {
            Player player = event.getPlayer();
            Utl.removeCampfirePlayer(player);
            Utl.removeSoulCampfirePlayer(player);
        }
    }
}
