package me.kin.vivace.interfaces;

import org.bukkit.entity.Player;

public interface Manager {
    void init();
    void save();
    void logMessage(Player p, String s);
    String getName();
}
