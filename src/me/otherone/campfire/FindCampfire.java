package me.otherone.campfire;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FindCampfire {

    public static void run(Plugin plugin) {
        Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                for (Player player : plugin.getServer().getOnlinePlayers()) {
                    int radius = 10;
                    int stop = 0;
                    int radius2 = 6;
                    int stop2 = 0;
                    Block middle = player.getLocation().getBlock();
                    //CAMPFIRE
                    for (int x = radius; x >= -radius; x--) {
                        if (stop == 1) { break; }
                        for (int y = radius; y >= -radius; y--) {
                            if (stop == 1) { break; }
                            for (int z = radius; z >= -radius; z--) {
                                if (stop == 1) { break; }
                                if (middle.getRelative(x, y, z).getType() == Material.CAMPFIRE) {
                                    Utl.addCampfirePlayer(player);
                                    stop++;
                                }
                            }
                        }
                    }
                    if (stop == 0 && Utl.campfirePlayer(player)) {
                        Utl.removeCampfirePlayer(player);
                    }
                    //SOUL CAMPFIRE
                    for (int x = radius2; x >= -radius2; x--) {
                        if (stop2 == 1) { break; }
                        for (int y = radius2; y >= -radius2; y--) {
                            if (stop2 == 1) { break; }
                            for (int z = radius2; z >= -radius2; z--) {
                                if (stop2 == 1) { break; }
                                if (middle.getRelative(x, y, z).getType() == Material.SOUL_CAMPFIRE) {
                                    Utl.addSoulCampfirePlayer(player);
                                    stop2++;
                                }
                            }
                        }
                    }
                    if (stop2 == 0 && Utl.soulCampfirePlayer(player)) {
                        Utl.removeSoulCampfirePlayer(player);
                    }
                }
            }
        }, 0L, 20);
    }
}
