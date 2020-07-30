package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Utl {

    public static int checkTicks() {
        return Math.max(Config.get().getInt("check-ticks"), 1);
    }

    private static List<String> CampfirePlayers = Config.get().getStringList("campfire-players");
    private static List<String> SoulCampfirePlayers = Config.get().getStringList("soul-campfire-players");

    //GET PLAYER LIST
    private static List<String> campfire() {
        if (CampfirePlayers == null) {
            return new ArrayList<>();
        }
        return CampfirePlayers;
    }
    private static List<String> soulCampfire() {
        if (SoulCampfirePlayers == null) {
            return new ArrayList<>();
        }
        return SoulCampfirePlayers;
    }

    //DETECT PLAYER
    public static boolean campfirePlayer(Player player) {
        return campfire().contains(player.getName());
    }
    public static boolean soulCampfirePlayer(Player player) {
        return soulCampfire().contains(player.getName());
    }

    //ADD PLAYER
    public static void addCampfirePlayer(Player player) {
        if (!(campfirePlayer(player))) {
            CampfirePlayers.add(player.getName());
            Config.get().set("campfire-players", CampfirePlayers);
            player.addPotionEffect(new PotionEffect(campfireEffect(), 999999999, campfireEffectLevel()));
        }
    }
    public static void addSoulCampfirePlayer(Player player) {
        if (!(soulCampfirePlayer(player))) {
            SoulCampfirePlayers.add(player.getName());
            Config.get().set("soul-campfire-players", SoulCampfirePlayers);
            player.addPotionEffect(new PotionEffect(soulCampfireEffect(), 999999999, soulCampfireEffectLevel()));
        }
    }

    //REMOVE PLAYER
    public static void removeCampfirePlayer(Player player) {
        if (campfirePlayer(player))
            player.removePotionEffect(campfireEffect());
        CampfirePlayers.remove(player.getName());
        Config.get().set("campfire-players", CampfirePlayers);
    }
    public static void removeSoulCampfirePlayer(Player player) {
        if (soulCampfirePlayer(player))
            player.removePotionEffect(soulCampfireEffect());
        SoulCampfirePlayers.remove(player.getName());
        Config.get().set("soul-campfire-players", SoulCampfirePlayers);
    }

    //EFFECT
    public static PotionEffectType campfireEffect() {
        if (PotionEffectType.getByName(Config.get().getString("campfire.effect")) == null) {
            return PotionEffectType.REGENERATION;
        }
        return PotionEffectType.getByName(Config.get().getString("campfire.effect"));
    }
    public static PotionEffectType soulCampfireEffect() {
        if (PotionEffectType.getByName(Config.get().getString("soul-campfire.effect")) == null) {
            return PotionEffectType.DAMAGE_RESISTANCE;
        }
        return PotionEffectType.getByName(Config.get().getString("soul-campfire.effect"));
    }

    //EFFECT LVL
    public static int campfireEffectLevel() {
        return Math.max(Config.get().getInt("campfire.level") - 1, 0);
    }
    public static int soulCampfireEffectLevel() {
        return Math.max(Config.get().getInt("soul-campfire.level") - 1, 0);
    }

    //RADIUS
    public static int campfireRadius() {
        return Math.max(Config.get().getInt("campfire.radius"), 1);
    }
    public static int soulCampfireRadius() {
        return Math.max(Config.get().getInt("soul-campfire.radius"), 1);
    }

}
