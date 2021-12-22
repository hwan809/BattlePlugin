package me.kin.vivace.battle.commands.args0;

import me.kin.vivace.interfaces.CustomExecutor;
import org.bukkit.entity.Player;

public class Stop implements CustomExecutor {
    @Override
    public boolean execute(Player player, String[] args) {
        return false;
    }

    @Override
    public void init() {

    }
}
