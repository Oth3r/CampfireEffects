package me.otherone.campfire;

import me.otherone.campfire.yml.Config;
import me.otherone.campfire.yml.addConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandCampfireEffects implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                System.out.println("[CampfireEffects] Usage: /campfireeffects reload");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                Utl.removeAll();
                Config.reload();
                addConfig.start();
                System.out.println("[CampfireEffects] Reloaded Config.");
            }
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(Utl.addColor("&cUsage: &f/campfireeffects reload"));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (!(player.hasPermission("campfireeffects.reload"))) { player.sendMessage(Utl.addColor("&cYou do not have permission to use this command!")); return true; }
            Utl.removeAll();
            Config.reload();
            addConfig.start();
            player.sendMessage(Utl.addColor("&aReloaded Config!"));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            if (player.hasPermission("campfireeffects.reload")) {
                return new ArrayList<>(Collections.singletonList("reload"));
            }
        }
        return new ArrayList<>();
    }
}
