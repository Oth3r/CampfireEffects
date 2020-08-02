package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Utl {
    private static PotionEffectType getEffect(String simple, String type) {
        if (PotionEffectType.getByName(simple) == null) {
            if (simple.equalsIgnoreCase("slowness")) return PotionEffectType.SLOW;
            if (simple.equalsIgnoreCase("haste")) return PotionEffectType.FAST_DIGGING;
            if (simple.equalsIgnoreCase("mining_fatigue")) return PotionEffectType.SLOW_DIGGING;
            if (simple.equalsIgnoreCase("strength")) return PotionEffectType.INCREASE_DAMAGE;
            if (simple.equalsIgnoreCase("instant_health")) return PotionEffectType.HEAL;
            if (simple.equalsIgnoreCase("instant_damage")) return PotionEffectType.HARM;
            if (simple.equalsIgnoreCase("jump_boost")) return PotionEffectType.JUMP;
            if (simple.equalsIgnoreCase("nausea")) return PotionEffectType.CONFUSION;
            if (simple.equalsIgnoreCase("resistance")) return PotionEffectType.DAMAGE_RESISTANCE;
            if (type.equalsIgnoreCase("soul-campfire")) {
                return PotionEffectType.DAMAGE_RESISTANCE;
            } else return PotionEffectType.REGENERATION;
        }
        return PotionEffectType.getByName(simple);
    }

    public static String addColor(final String string) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', string);
    }

    public static int checkTicks() {
        return Math.max(Config.get().getInt("check-ticks"), 1);
    }

    private static List<String> CampfirePlayers = Config.get().getStringList("campfire-players");
    private static List<String> SoulCampfirePlayers = Config.get().getStringList("soul-campfire-players");

    //REMOVE ALL
    public static void removeAll() {
        for (Player player: Bukkit.getOnlinePlayers()) {
            Utl.removeCampfirePlayer(player);
            Utl.removeSoulCampfirePlayer(player);
        }
        if (Config.get().getString("campfire-players") != null)
            Config.get().set("campfire-players", null);
        if (Config.get().getString("soulcampfire-players") != null)
            Config.get().set("soulcampfire-players", null);
    }

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
        return getEffect(Config.get().getString("campfire.effect"), "campfire");
    }
    public static PotionEffectType soulCampfireEffect() {
        return getEffect(Config.get().getString("soul-campfire.effect"), "soul-campfire");
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
