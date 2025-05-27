package me.keitoc.commandblocker;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class CommandBlocker extends JavaPlugin {

    private static CommandBlocker instance;
    private List<String> blockedCommands;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadBlockedCommands();
        getServer().getPluginManager().registerEvents(new CommandBlockerListener(), this);
        getCommand("commandblocker").setExecutor(new CommandReloadCommand());
        getLogger().info("CommandBlocker habilitado.");
    }

    public void loadBlockedCommands() {
        blockedCommands = getConfig().getStringList("blocked-commands");
    }

    public List<String> getBlockedCommands() {
        return blockedCommands;
    }

    public static CommandBlocker getInstance() {
        return instance;
    }
}
