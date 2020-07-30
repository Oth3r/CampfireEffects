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
}
