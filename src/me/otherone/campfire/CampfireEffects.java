package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import me.otherone.campfire.yml.addConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class CampfireEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        Config.setup();
        addConfig.start();

        getServer().getPluginManager().registerEvents(new CampfireEvents(), this);

        getCommand("campfireeffects").setExecutor(new CommandCampfireEffects());
        getCommand("campfireeffects").setTabCompleter(new CommandCampfireEffects());

        FindCampfire.run(this);
    }

    @Override
    public void onDisable() {
        Utl.removeAll();
    }

    //speed, slowness, haste, mining_fatigue, strength, instant_health, instant_damage, jump_boost, nausea, regeneration, resistance, fire_resistance, water_breathing, invisibility, blindness, night_vision, hunger, weakness, poison, wither, health_boost, absorption, saturation, glowing, levitation, luck, unluck, slow_falling, conduit_power, dolphins_grace, bad_omen, hero_of_the_village


    //speed, slowness, haste, mining_fatigue, strength,
    //instant_health, instant_damage, jump_boost, nausea,
    //regeneration, resistance, fire_resistance, water_breathing,
    //invisibility, blindness, night_vision, hunger, weakness,
    //poison, wither, health_boost, absorption, saturation,
    //glowing, levitation, luck, unluck, slow_falling,
    //conduit_power, dolphins_grace, bad_omen, hero_of_the_village

    //FIX DEATH RESETTING EFFECTS
    //ADD BETTER EFFECTS NAMES
}
