package me.kin.vivace.battle;

import me.kin.vivace.battle.commands.BattleCommands;
import me.kin.vivace.Main;
import me.kin.vivace.battle.commands.args0.*;
import me.kin.vivace.interfaces.CustomExecutor;
import me.kin.vivace.interfaces.Manager;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleManager implements Manager {

    public static Map<String, CustomExecutor> argsMap = new HashMap<>();

    public static List<World> battleMaps = new ArrayList<>();

    private void setArgsMap() {
        argsMap.put("시작", new Start());
        argsMap.put("생성", new Create());
        argsMap.put("삭제", new Delete());
        argsMap.put("목록", new MapList());
        argsMap.put("종료", new Stop());
        argsMap.put("위치", new Position());
        argsMap.put("설정", new Settings());
        argsMap.put("스폰", new Spawn());
        argsMap.put("관리", new Manage());
        argsMap.put("보상", new Reward());
    }

    private void setExecutor() {
        for (CustomExecutor ce : argsMap.values()) {
            ce.init();
        }
    }

    @Override
    public void init() {
        setArgsMap();
        setExecutor();

        Main.getInstance().getCommand(BattleCommands.battleCommandName).setExecutor(new BattleCommands());
    }

    @Override
    public void save() {

    }

    @Override
    public void logMessage(Player p, String s) {
        p.sendMessage(ChatColor.GOLD + "[ 배틀 ] " + ChatColor.WHITE + s);
    }

    @Override
    public String getName() {
        return "BATTLE";
    }
}
