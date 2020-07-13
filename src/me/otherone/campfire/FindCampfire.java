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
                for (Player p : plugin.getServer().getOnlinePlayers()) {
                    int radius = 10;
                    int stop = 0;
                    int radius2 = 6;
                    int stop2 = 0;
                    Block middle = p.getLocation().getBlock();
                    //CAMPFIRE
                    for (int x = radius; x >= -radius; x--) {
                        if (stop == 1) {
                            break;
                        }
                        for (int y = radius; y >= -radius; y--) {
                            if (stop == 1) {
                                break;
                            }
                            for (int z = radius; z >= -radius; z--) {
                                if (stop == 1) {
                                    break;
                                }
                                if (middle.getRelative(x, y, z).getType() == Material.CAMPFIRE) {
                                    if (!(p.hasPotionEffect(PotionEffectType.REGENERATION))) {
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 0));
                                    }
                                    stop++;
                                }
                            }
                        }
                    }
                    if (stop == 0 && p.hasPotionEffect(PotionEffectType.REGENERATION)) {
                        if (p.getPotionEffect(PotionEffectType.REGENERATION).getDuration() >= 72000) {
                            p.removePotionEffect(PotionEffectType.REGENERATION);
                        }
                    }
                    //SOUL CAMPFIRE
                    for (int x = radius2; x >= -radius2; x--) {
                        if (stop2 == 1) {
                            break;
                        }
                        for (int y = radius2; y >= -radius2; y--) {
                            if (stop2 == 1) {
                                break;
                            }
                            for (int z = radius2; z >= -radius2; z--) {
                                if (stop2 == 1) {
                                    break;
                                }
                                if (middle.getRelative(x, y, z).getType() == Material.SOUL_CAMPFIRE) {
                                    if (!(p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))) {
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 0));
                                    }
                                    stop2++;
                                }
                            }
                        }
                    }
                    if (stop2 == 0 && p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                        if (p.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getDuration() >= 72000) {
                            p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                        }
                    }
                }
            }
        }, 0L, 20);
    }
}
