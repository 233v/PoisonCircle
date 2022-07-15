package com.vvv.PoisonCircle;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!sender.isOp()) {
            sender.sendMessage("你不是管理员");
            return true;
        }

        if (args.length == 2 && args[0].equals("reset")) {
            World world = Bukkit.getWorld(args[1]);

            if (world == null) {
                sender.sendMessage("世界不存在");
                return true;
            }

            WorldBorder worldBorder = world.getWorldBorder();
            worldBorder.reset();

            sender.sendMessage("世界边界已重置");
        } else if (args.length == 7 && args[0].equals("set")) {

            World world = Bukkit.getWorld(args[1]);

            if (world == null) {
                sender.sendMessage("世界不存在");
                return true;
            }

            double x = Double.parseDouble(args[2]);
            double z = Double.parseDouble(args[3]);
            int size = Integer.parseInt(args[4]);
            int time = Integer.parseInt(args[5]);
            int damage = Integer.parseInt(args[6]);

            WorldBorder worldBorder = world.getWorldBorder();
            worldBorder.setCenter(x, z);
            worldBorder.setSize(size, time);
            worldBorder.setDamageAmount(damage);
            sender.sendMessage("边界设置成功");
        } else {
            sender.sendMessage("你的参数有误");
        }

        return false;
    }
}

