package me.kin.vivace.battle.commands;

import me.kin.vivace.battle.BattleManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BattleCommands implements CommandExecutor {
    public final static String battleCommandName = "배틀";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String name = command.getName();

        if (!name.equals(battleCommandName)) return true;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "플레이어만 사용할 수 있습니다.");
            return true;
        }

        if (args.length == 0) {
            if (sender.isOp()) {
                sender.sendMessage(HelpMessages.BATTLE_COMMAND.getHelpMessage());
            }

            return true;
        }

        String subCommandName = args[0];

        if (BattleManager.argsMap.containsKey(subCommandName)) {
            return BattleManager.argsMap.get(subCommandName).execute((Player) sender, args);
        }

        return false;
    }
}
