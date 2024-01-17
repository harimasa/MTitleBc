package me.matt.mtitlebc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MTitleBc extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("titlebc").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("titlebc")) {
            if (sender.hasPermission("mtbc.title")) {
                if (args.length < 2) {
                    sender.sendMessage(ChatColor.RED + "Использование: /titlebc <заголовок> <текст>");
                    return true;
                }

                String title = ChatColor.translateAlternateColorCodes('&', args[0]);
                String text = ChatColor.translateAlternateColorCodes('&', args[1]);

                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(title, text, 10, 70, 20);
                }

                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "У вас нет разрешения на выполнение этой команды.");
                return true;
            }
        }
        return false;
    }
}