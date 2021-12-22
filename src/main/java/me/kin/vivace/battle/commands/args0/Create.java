package me.kin.vivace.battle.commands.args0;

import me.kin.vivace.Main;
import me.kin.vivace.battle.BattleManager;
import me.kin.vivace.interfaces.CustomExecutor;
import me.kin.vivace.interfaces.Manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Create implements CustomExecutor {

    private Manager battleManager;

    @Override
    public boolean execute(Player player, String[] args) {
        if (!player.isOp()) return true;

        if (args.length == 1) {
            battleManager.logMessage(player, ChatColor.RED + "추가할 맵의 월드명을 입력해주세요.");
            return true;
        }

        String mapName = args[1];

        for (World map : BattleManager.battleMaps) {
            if (map.getName().equals(mapName)) {
                battleManager.logMessage(player, ChatColor.RED + "이미 맵에 추가되어 있는 월드입니다.");
                return true;
            }
        }

        for (World world : Bukkit.getWorlds()) {
            if (world.getName().equals(mapName)) {
                BattleManager.battleMaps.add(world);
                battleManager.logMessage(player, ChatColor.GREEN + "성공적으로 월드 [ " +
                        ChatColor.GRAY + mapName + ChatColor.GREEN + " ] 를 맵에 추가했습니다.");

                return true;
            }
        }

        battleManager.logMessage(player, ChatColor.RED + "그런 이름의 월드가 없습니다.");
        return true;
    }

    @Override
    public void init() {
        this.battleManager = Main.getManager("BATTLE");
    }
}
