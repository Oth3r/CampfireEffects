package me.otherone.campfire;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class CampfireEvents implements Listener {

    @EventHandler
    public static void onPlayerDisconnect(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Utl.removeCampfirePlayer(player);
        Utl.removeSoulCampfirePlayer(player);
    }
}
