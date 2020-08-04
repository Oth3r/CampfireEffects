package me.otherone.campfire;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FindCampfire {

    public static void run(Plugin plugin) {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player player : plugin.getServer().getOnlinePlayers()) {
                int campfireRadius = Utl.campfireRadius();
                int soulCampfireRadius = Utl.soulCampfireRadius();
                int campfireStop = 0;
                int soulCampfireStop = 0;
                Block middle = player.getLocation().getBlock();

                //CAMPFIRE
                for (int x = campfireRadius; x >= -campfireRadius; x--) {
                    if (campfireStop > 0) { break; }
                    for (int y = campfireRadius; y >= -campfireRadius; y--) {
                        if (campfireStop > 0) { break; }
                        for (int z = campfireRadius; z >= -campfireRadius; z--) {
                            if (campfireStop > 0) { break; }
                            if (middle.getRelative(x, y, z).getType() == Material.CAMPFIRE) {
                                Lightable light = (Lightable) middle.getRelative(x, y, z).getBlockData();
                                if (light.isLit()) {
                                    Utl.addCampfirePlayer(player);
                                    campfireStop++;
                                }
                            }
                        }
                    }
                }
                if (campfireStop == 0) {
                    Utl.removeCampfirePlayer(player);
                }

                //SOUL CAMPFIRE
                for (int x = soulCampfireRadius; x >= -soulCampfireRadius; x--) {
                    if (soulCampfireStop > 0) { break; }
                    for (int y = soulCampfireRadius; y >= -soulCampfireRadius; y--) {
                        if (soulCampfireStop > 0) { break; }
                        for (int z = soulCampfireRadius; z >= -soulCampfireRadius; z--) {
                            if (soulCampfireStop > 0) { break; }
                            if (middle.getRelative(x, y, z).getType() == Material.SOUL_CAMPFIRE) {
                                Lightable light = (Lightable) middle.getRelative(x, y, z).getBlockData();
                                if (light.isLit()) {
                                    Utl.addSoulCampfirePlayer(player);
                                    soulCampfireStop++;
                                }
                            }
                        }
                    }
                }
                if (soulCampfireStop == 0) {
                    Utl.removeSoulCampfirePlayer(player);
                }
            }
        }, 0L, Utl.checkTicks());
    }
}
