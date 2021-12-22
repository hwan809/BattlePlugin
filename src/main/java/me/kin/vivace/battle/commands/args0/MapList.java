package me.kin.vivace.battle.commands.args0;

import me.kin.vivace.Main;
import me.kin.vivace.battle.BattleManager;
import me.kin.vivace.interfaces.CustomExecutor;
import me.kin.vivace.interfaces.Manager;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MapList implements CustomExecutor {

    private Manager battleManager;

    @Override
    public boolean execute(Player player, String[] args) {
        if (!player.isOp()) return true;

        battleManager.logMessage(player, ChatColor.GREEN + "맵 이름 목록을 불러옵니다.");

        for (World map : BattleManager.battleMaps) {
            player.sendMessage(ChatColor.GRAY + "- " + map.getName());
        }

        return true;
    }

    @Override
    public void init() {
        this.battleManager = Main.getManager("BATTLE");
    }
}
