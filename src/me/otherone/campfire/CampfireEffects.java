package me.otherone.campfire;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CampfireEffects extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CampfireEvents(), this);
        FindCampfire.run(this);
    }

    @Override
    public void onDisable() {
        for (Player player: Bukkit.getOnlinePlayers()) {
            Utl.removeCampfirePlayer(player);
            Utl.removeSoulCampfirePlayer(player);
        }

    }

    //TODO
    // make check ticks config option work

}
