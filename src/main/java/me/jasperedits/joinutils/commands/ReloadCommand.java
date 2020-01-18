package me.jasperedits.joinutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.jasperedits.joinutils.JoinUtilsPlugin;

public class ReloadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission(JoinUtilsPlugin.getInstance().getConfig().getString("permissions.cmdreload"))) {
			JoinUtilsPlugin.getInstance().reloadConfig();
			JoinUtilsPlugin.sendMessageFromConfig(sender, "reloadcmd.reloaddone");
		} else {
			JoinUtilsPlugin.sendMessageFromConfig(sender, "reloadcmd.notenoughpermissions");
		}
		return false;
	}

}
