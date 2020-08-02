package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Utl {

    //speed, slowness, haste, mining_fatigue, strength,
    //instant_health, instant_damage, jump_boost, nausea,
    //regeneration, resistance, fire_resistance, water_breathing,
    //invisibility, blindness, night_vision, hunger, weakness,
    //poison, wither, health_boost, absorption, saturation,
    //glowing, levitation, luck, unluck, slow_falling,
    //conduit_power, dolphins_grace, bad_omen, hero_of_the_village

    private static PotionEffectType getEffect(String simple) {
        if (simple.equalsIgnoreCase("speed")) {
            return PotionEffectType.SPEED;
        }
        if (simple.equalsIgnoreCase("slowness")) {
            return PotionEffectType.SLOW;
        }
        if (simple.equalsIgnoreCase("haste")) {
            return PotionEffectType.FAST_DIGGING;
        }
        if (simple.equalsIgnoreCase("mining_fatigue")) {
            return PotionEffectType.SLOW_DIGGING;
        }
        if (simple.equalsIgnoreCase("strength")) {
            return PotionEffectType.INCREASE_DAMAGE;
        }
        //instant_health, instant_damage, jump_boost, nausea,
        if (simple.equalsIgnoreCase("instant_health")) {
            return PotionEffectType.HEAL;
        }
        if (simple.equalsIgnoreCase("instant_damage")) {
            return PotionEffectType.HARM;
        }
        if (simple.equalsIgnoreCase("jump_boost")) {
            return PotionEffectType.JUMP;
        }
        if (simple.equalsIgnoreCase("nausea")) {
            return PotionEffectType.CONFUSION;
        }
        //regeneration, resistance, fire_resistance, water_breathing,
        if (simple.equalsIgnoreCase("regeneration")) {
            return PotionEffectType.REGENERATION;
        }
        if (simple.equalsIgnoreCase("resistance")) {
            return PotionEffectType.DAMAGE_RESISTANCE;
        }
        if (simple.equalsIgnoreCase("fire_resistance")) {
            return PotionEffectType.FIRE_RESISTANCE;
        }
        if (simple.equalsIgnoreCase("water_breathing")) {
            return PotionEffectType.WATER_BREATHING;
        }
        //invisibility, blindness, night_vision, hunger, weakness,
        if (simple.equalsIgnoreCase("invisibility")) {
            return PotionEffectType.INVISIBILITY;
        }
        if (simple.equalsIgnoreCase("blindness")) {
            return PotionEffectType.BLINDNESS;
        }
        if (simple.equalsIgnoreCase("night_vision")) {
            return PotionEffectType.NIGHT_VISION;
        }
        if (simple.equalsIgnoreCase("hunger")) {
            return PotionEffectType.HUNGER;
        }
        if (simple.equalsIgnoreCase("weakness")) {
            return PotionEffectType.WEAKNESS;
        }
        //poison, wither, health_boost, absorption, saturation,
        if (simple.equalsIgnoreCase("poison")) {
            return PotionEffectType.POISON;
        }
        if (simple.equalsIgnoreCase("wither")) {
            return PotionEffectType.WITHER;
        }
        if (simple.equalsIgnoreCase("health_boost")) {
            return PotionEffectType.HEALTH_BOOST;
        }
        if (simple.equalsIgnoreCase("absorption")) {
            return PotionEffectType.ABSORPTION;
        }
        if (simple.equalsIgnoreCase("saturation")) {
            return PotionEffectType.SATURATION;
        }
        //glowing, levitation, luck, unluck, slow_falling,
        if (simple.equalsIgnoreCase("glowing")) {
            return PotionEffectType.GLOWING;
        }
        if (simple.equalsIgnoreCase("levitation")) {
            return PotionEffectType.LEVITATION;
        }
        if (simple.equalsIgnoreCase("luck")) {
            return PotionEffectType.LUCK;
        }
        if (simple.equalsIgnoreCase("unluck")) {
            return PotionEffectType.UNLUCK;
        }
        if (simple.equalsIgnoreCase("slow_falling")) {
            return PotionEffectType.SLOW_FALLING;
        }
        //conduit_power, dolphins_grace, bad_omen, hero_of_the_village
        if (simple.equalsIgnoreCase("conduit_power")) {
            return PotionEffectType.CONDUIT_POWER;
        }
        if (simple.equalsIgnoreCase("dolphins_grace")) {
            return PotionEffectType.DOLPHINS_GRACE;
        }
        if (simple.equalsIgnoreCase("bad_omen")) {
            return PotionEffectType.BAD_OMEN;
        }
        if (simple.equalsIgnoreCase("hero_of_the_village")) {
            return PotionEffectType.HERO_OF_THE_VILLAGE;
        }
        //SIMPLEIFY THE CORRECT ONES
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
