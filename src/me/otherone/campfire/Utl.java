package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import org.bukkit.entity.Player;
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
        }
    }

    public static void removeCampfirePlayer(Player player) {
        CampfirePlayers.remove(player.getName());
        Config.get().set("campfire-players", CampfirePlayers);
    }

    private static List<String> SoulCampfirePlayers = Config.get().getStringList("campfire-players");

    private static List<String> soulCampfire() {
        if (CampfirePlayers == null) {
            return new ArrayList<>();
        }
        return CampfirePlayers;
    }

    public static boolean soulCampfirePlayer(Player player) {
        if (campfire().contains(player.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public static void addSoulCampfirePlayer(Player player) {
        if (!(campfirePlayer(player))) {
            CampfirePlayers.add(player.getName());
            Config.get().set("campfire-players", CampfirePlayers);
        }
    }

    public static void removeSoulCampfirePlayer(Player player) {
        CampfirePlayers.remove(player.getName());
        Config.get().set("campfire-players", CampfirePlayers);
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
