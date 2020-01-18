package me.jasperedits.joinutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.jasperedits.joinutils.core.Main;

public class SpawnCommand implements CommandExecutor {

	@Override 
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		FileConfiguration config = Main.getInstance().getConfig();
		if (Main.getInstance().getConfig().getBoolean("modules.spawncmd")) {
			if (!(sender instanceof Player)) {
				Main.sendMessageFromConfig(sender, "spawncmd.onlyplayers");
			} else {
				Player p = (Player) sender;
				World w = Bukkit.getWorld(config.getString("spawn.world"));
				if (w != null) {
					p.teleport(getLocationFromConfig(config));
					Main.sendMessageFromConfig(p, "spawncmd.teleporting"); // Sends the message if it's enabled.
				} else if (!(config.getString("messages.spawncmd.nonexistantworldplayer").equals("0"))) { // Checks if the message is disabled or not.
					p.sendMessage(Main.c(config.getString("messages.spawncmd.nonexistantworldplayer").replace("%world%", config.getString("spawn.world"))));
					if (!(config.getString("messages.spawncmd.nonexistantworldconsole")).equals("0"))  // Checks if the message is disabled or not.
						Bukkit.getConsoleSender().sendMessage(Main.c(config.getString("messages.spawncmd.nonexistantworldconsole")).replace("%world%", config.getString("spawn.world")));
				}
			}
		} else {
			Main.sendMessageFromConfig(sender, "spawncmd.disabled");
		}
		return false;
	}

	private static Location getLocationFromConfig(FileConfiguration config) {
		Location loc = new Location(Bukkit.getWorld(config.getString("spawn.world")), 
				config.getDouble("spawn.x"), 
				config.getDouble("spawn.y"), 
				config.getDouble("spawn.z"));
		loc.setYaw(config.getInt("spawn.yaw"));
		loc.setPitch(config.getInt("spawn.pitch"));
		return loc;
	}
}