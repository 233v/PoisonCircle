package com.vvv.PoisonCircle;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class BorderDamager extends BukkitRunnable {
    @Override
    public void run() {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player player : onlinePlayers) {
            World world = player.getWorld();
            WorldBorder worldBorder = world.getWorldBorder();
            if (!worldBorder.isInside(player.getLocation())) {
                player.damage(1.0);
            }

        }
    }
}
