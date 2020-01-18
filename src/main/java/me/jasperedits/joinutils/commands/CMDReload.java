package me.jasperedits.joinutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.jasperedits.joinutils.core.Main;

public class CMDReload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission(Main.getInstance().getConfig().getString("permissions.cmdreload"))) {
			Main.getInstance().reloadConfig();
			Main.sendMessageFromConfig(sender, "reloadcmd.reloaddone");
		} else {
			Main.sendMessageFromConfig(sender, "reloadcmd.notenoughpermissions");
		}
		return false;
	}

}
