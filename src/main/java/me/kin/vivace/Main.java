package me.kin.vivace;

import me.kin.vivace.battle.BattleManager;
import me.kin.vivace.interfaces.Manager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public static List<Manager> systemManagers = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        systemManagers.add(new BattleManager());

        for (Manager classes : systemManagers) {
            classes.init();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        for (Manager classes : systemManagers) {
            classes.save();
        }
    }

    public static Manager getManager(String s) {
        for (Manager sm : systemManagers) {
            if (s.equals(sm.getName())) {
                return sm;
            }
        }

        return null;
    }
}
