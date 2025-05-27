package me.keitoc.commandblocker;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            CommandBlocker plugin = CommandBlocker.getInstance();
            plugin.reloadConfig();
            plugin.loadBlockedCommands();
            sender.sendMessage(ChatColor.GREEN + "Configuración de CommandBlocker recargada.");
            return true;
        }
        sender.sendMessage(ChatColor.YELLOW + "Usa: /commandblocker reload");
        return true;
    }
}
