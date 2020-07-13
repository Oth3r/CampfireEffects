package me.otherone.campfire;

import org.bukkit.plugin.java.JavaPlugin;

public class CampfireEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        FindCampfire.run(this);
    }

    @Override
    public void onDisable() {

    }

}
