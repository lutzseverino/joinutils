package me.jasperedits.joinutils;

import java.util.List;

import org.bukkit.event.Listener;

public class Motd implements Listener {

    public static List<String> motdMessage;

    static {
    	motdMessage = JoinUtilsPlugin.getInstance().getConfig().getStringList("motd");
    }
}
