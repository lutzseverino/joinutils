package me.jasperedits.joinutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jasperedits.joinutils.core.Main;

public class CMDSpawn implements CommandExecutor {

	@Override 
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.getInstance().getConfig().getBoolean("modules.spawncmd")) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.c((Main.getInstance().getConfig().getString("messages.spawncmd.onlyplayers"))));
			} else {
				Player p = (Player) sender;	
				Location loc = new Location(Bukkit.getWorld(Main.getInstance().getConfig().getString("spawn.world")), 
						Main.getInstance().getConfig().getDouble("spawn.x"), 
						Main.getInstance().getConfig().getDouble("spawn.y"), 
						Main.getInstance().getConfig().getDouble("spawn.z"));
				loc.setYaw(Main.getInstance().getConfig().getInt("spawn.yaw"));
				loc.setPitch(Main.getInstance().getConfig().getInt("spawn.pitch"));
				p.teleport(loc);
				p.sendMessage(Main.c((Main.getInstance().getConfig().getString("messages.spawncmd.teleporting"))));
			}
		} else {
			sender.sendMessage(Main.c((Main.getInstance().getConfig().getString("messages.spawncmd.disabled"))));
		}
		return false;
	}
}