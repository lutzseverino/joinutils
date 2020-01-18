package me.jasperedits.simplespawn.core;

import java.util.List;

import org.bukkit.event.Listener;

public class Motd implements Listener {

    public static List<String> motdMessage;

    static {
    	motdMessage = Main.getInstance().getConfig().getStringList("motd");
    }
}
