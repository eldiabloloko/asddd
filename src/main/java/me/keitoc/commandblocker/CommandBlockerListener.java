package me.keitoc.commandblocker;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.TabCompleteEvent;

public class CommandBlockerListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage().toLowerCase();

        for (String cmd : CommandBlocker.getInstance().getBlockedCommands()) {
            if (message.startsWith(cmd)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "Este comando está bloqueado.");
                return;
            }
        }
    }

    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        String buffer = event.getBuffer().toLowerCase();

        for (String cmd : CommandBlocker.getInstance().getBlockedCommands()) {
            if (buffer.startsWith(cmd)) {
                event.setCompletions(java.util.Collections.emptyList());
                return;
            }
        }
    }
}
