package me.jasperedits.joinutils.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jasperedits.joinutils.core.Main;
import me.jasperedits.joinutils.core.Motd;

public class JoinListener  implements Listener {

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (Main.getInstance().getConfig().getBoolean("modules.spawnonjoin")) {
			p.setGameMode(GameMode.valueOf(Main.getInstance().getConfig().getString("spawn.gamemode").toUpperCase()));
			Location loc = new Location(Bukkit.getWorld(Main.getInstance().getConfig().getString("spawn.world")), 
					Main.getInstance().getConfig().getDouble("spawn.x"), 
					Main.getInstance().getConfig().getDouble("spawn.y"), 
					Main.getInstance().getConfig().getDouble("spawn.z"));
			loc.setYaw(Main.getInstance().getConfig().getInt("spawn.yaw"));
			loc.setPitch(Main.getInstance().getConfig().getInt("spawn.pitch"));
			p.teleport(loc);

			if (Main.getInstance().getConfig().getBoolean("modules.motd")) {
				for (String lineas : Motd.motdMessage) {
					p.sendMessage(Main.c(lineas));
				}
			}
		}
	}
}
