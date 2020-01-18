package me.jasperedits.joinutils;

import org.bukkit.ChatColor;

public class StringUtilities {
	
	public static String stripColorCores(String c) {
		return ChatColor.translateAlternateColorCodes('&', c);
	}
}
