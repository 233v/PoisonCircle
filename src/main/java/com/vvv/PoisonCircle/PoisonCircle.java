package com.vvv.PoisonCircle;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class PoisonCircle extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("插件已成功开启！");
        setCommandExecutor();
    }
    private void setCommandExecutor() {
        final PluginCommand Command=Bukkit.getPluginCommand("PoisonCircle");

        if (Command != null) {
            Command.setExecutor(new TestCommand());
        }
    }
}
