package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Utl {

    private static List<String> CampfirePlayers = Config.get().getStringList("campfire-players");

    private static List<String> campfire() {
        if (CampfirePlayers == null) {
            return new ArrayList<>();
        }
        return CampfirePlayers;
    }

    public static boolean campfirePlayer(Player player) {
        if (campfire().contains(player.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public static void addCampfirePlayer(Player player) {
        if (!(campfirePlayer(player))) {
            CampfirePlayers.add(player.getName());
            Config.get().set("campfire-players", CampfirePlayers);
            player.addPotionEffect(new PotionEffect(campfireEffect(), 999999999, campfireEffectLevel()));
        }
    }

    public static void removeCampfirePlayer(Player player) {
        if (campfirePlayer(player))
            player.removePotionEffect(campfireEffect());
        CampfirePlayers.remove(player.getName());
        Config.get().set("campfire-players", CampfirePlayers);

    }

    private static List<String> SoulCampfirePlayers = Config.get().getStringList("soulcampfire-players");

    private static List<String> soulCampfire() {
        if (SoulCampfirePlayers == null) {
            return new ArrayList<>();
        }
        return SoulCampfirePlayers;
    }

    public static boolean soulCampfirePlayer(Player player) {
        if (soulCampfire().contains(player.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public static void addSoulCampfirePlayer(Player player) {
        if (!(soulCampfirePlayer(player))) {
            SoulCampfirePlayers.add(player.getName());
            Config.get().set("soulcampfire-players", SoulCampfirePlayers);
            player.addPotionEffect(new PotionEffect(soulCampfireEffect(), 999999999, soulCampfireEffectLevel()));
        }
    }

    public static void removeSoulCampfirePlayer(Player player) {
        if (soulCampfirePlayer(player))
            player.removePotionEffect(soulCampfireEffect());
        SoulCampfirePlayers.remove(player.getName());
        Config.get().set("soulcampfire-players", SoulCampfirePlayers);
    }

    public static int effectTicks() {
        return Config.get().getInt("check-ticks");
    }

    public static PotionEffectType campfireEffect() {
        if (PotionEffectType.getByName(Config.get().getString("campfire.effect").toUpperCase()) == null) {
            return PotionEffectType.REGENERATION;
        }
        return PotionEffectType.getByName(Config.get().getString("campfire.effect").toUpperCase());
    }

    public static int campfireEffectLevel() {
        if (Config.get().getInt("campfire.level") - 1 < 0) {
            return 0;
        }
        return Config.get().getInt("campfire.level") - 1;
    }

    public static int campfireRadius() {
        return Config.get().getInt("campfire.radius");
    }

    public static PotionEffectType soulCampfireEffect() {
        if (PotionEffectType.getByName(Config.get().getString("soul-campfire.effect").toUpperCase()) == null) {
            return PotionEffectType.DAMAGE_RESISTANCE;
        }
        return PotionEffectType.getByName(Config.get().getString("soul-campfire.effect").toUpperCase());
    }

    public static int soulCampfireEffectLevel() {
        if (Config.get().getInt("soul-campfire.level") - 1 < 0) {
            return 0;
        }
        return Config.get().getInt("soul-campfire.level") - 1;
    }

    public static int soulCampfireRadius() {
        return Config.get().getInt("soul-campfire.radius");
    }
}
