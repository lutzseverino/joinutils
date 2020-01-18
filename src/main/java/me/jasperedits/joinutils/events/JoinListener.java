package me.jasperedits.joinutils.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jasperedits.joinutils.JoinUtilsPlugin;
import me.jasperedits.joinutils.Motd;

public class JoinListener  implements Listener {

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (JoinUtilsPlugin.getInstance().getConfig().getBoolean("modules.spawnonjoin")) {
			p.setGameMode(GameMode.valueOf(JoinUtilsPlugin.getInstance().getConfig().getString("spawn.gamemode").toUpperCase()));
			Location loc = new Location(Bukkit.getWorld(JoinUtilsPlugin.getInstance().getConfig().getString("spawn.world")), 
					JoinUtilsPlugin.getInstance().getConfig().getDouble("spawn.x"), 
					JoinUtilsPlugin.getInstance().getConfig().getDouble("spawn.y"), 
					JoinUtilsPlugin.getInstance().getConfig().getDouble("spawn.z"));
			loc.setYaw(JoinUtilsPlugin.getInstance().getConfig().getInt("spawn.yaw"));
			loc.setPitch(JoinUtilsPlugin.getInstance().getConfig().getInt("spawn.pitch"));
			p.teleport(loc);

			if (JoinUtilsPlugin.getInstance().getConfig().getBoolean("modules.motd")) {
				for (String lineas : Motd.motdMessage) {
					p.sendMessage(JoinUtilsPlugin.c(lineas));
				}
			}
		}
	}
}
