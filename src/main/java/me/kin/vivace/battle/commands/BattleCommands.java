package me.kin.vivace.battle.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BattleCommands implements CommandExecutor {
    public final static String battleCommandName = "배틀";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String name = command.getName();

        if (!name.equals(battleCommandName)) return false;
        if (args.length == 0) {
            if (sender.isOp()) {
                sender.sendMessage(HelpMessages.BATTLE_COMMAND.getHelpMessage());
            }

            return true;
        }

        String subCommandName = args[0];

        return true;
    }
}
