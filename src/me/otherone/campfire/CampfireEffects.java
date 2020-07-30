package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import me.otherone.campfire.yml.addConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CampfireEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        Config.setup();
        addConfig.start();
        getServer().getPluginManager().registerEvents(new CampfireEvents(), this);
        FindCampfire.run(this);
    }

    @Override
    public void onDisable() {
        for (Player player: Bukkit.getOnlinePlayers()) {
            Utl.removeCampfirePlayer(player);
            Utl.removeSoulCampfirePlayer(player);
        }
        if (Config.get().getString("campfire-players") != null)
            Config.get().set("campfire-players", null);
        if (Config.get().getString("soulcampfire-players") != null)
            Config.get().set("soulcampfire-players", null);
    }
}
