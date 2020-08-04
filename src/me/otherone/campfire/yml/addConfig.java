package me.otherone.campfire.yml;

public class addConfig {

    public static void start() {
        if (Config.get().getString("config-version") == null) {
            Config.get().set("config-version", 1.0);
            Config.get().set("check-ticks", 20);
            Config.get().set("All effects", "speed, slowness, haste, mining_fatigue, strength, " +
                    "instant_health, instant_damage, jump_boost, nausea, regeneration, resistance, " +
                    "fire_resistance, water_breathing, invisibility, blindness, night_vision, hunger, " +
                    "weakness, poison, wither, health_boost, absorption, saturation, glowing, levitation, " +
                    "luck, unluck, slow_falling, conduit_power, dolphins_grace, bad_omen, hero_of_the_village");
            Config.get().set("campfire.effect", "regeneration");
            Config.get().set("campfire.level", 1);
            Config.get().set("campfire.radius", 10);
            Config.get().set("soul-campfire.effect", "resistance");
            Config.get().set("soul-campfire.level", 1);
            Config.get().set("soul-campfire.radius", 6);
        }
        if (Config.get().getString("campfire.effect") == null) {
            Config.get().set("campfire.effect", "REGENERATION");
        }
        if (Config.get().getString("soul-campfire.effect") == null) {
            Config.get().set("soul-campfire.effect", "DAMAGE_RESISTANCE");
        }
        Config.save();
    }
}
