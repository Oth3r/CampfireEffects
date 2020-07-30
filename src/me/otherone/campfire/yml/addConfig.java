package me.otherone.campfire.yml;

public class addConfig {

    public static void start() {
        if (Config.get().getString("config-version") == null) {
            Config.get().set("config-version", 1.0);
            Config.get().set("check-ticks", 20);
            Config.get().set("campfire.effect", "REGENERATION");
            Config.get().set("campfire.level", 1);
            Config.get().set("campfire.radius", 10);
            Config.get().set("soul-campfire.effect", "DAMAGE_RESISTANCE");
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
