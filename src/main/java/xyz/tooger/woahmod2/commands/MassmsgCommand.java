package xyz.tooger.woahmod2.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import xyz.tooger.woahmod2.utils;

import java.util.ArrayList;
import java.util.Random;

public class MassmsgCommand extends CommandBase {
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length <= 1) {
            utils.sendMessage("&b&m" + utils.br());
            utils.sendMessage("&bMass Message");
            utils.sendMessage("&f");
            utils.sendMessage("&fRuns a command once for every player on the server.");
            utils.sendMessage("&f");
            utils.sendMessage("&bVariables");
            utils.sendMessage("&f%player% &b- &fThe player that the command is being run for.");
            utils.sendMessage("&f");
            utils.sendMessage("&bDelay");
            utils.sendMessage("&fThe delay is in milliseconds. This means that to make it a one second delay, you should use '1000'.");
            utils.sendMessage("&b&m" + utils.br());
        } else {
            try {
                Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                utils.sendMessage("&bWoahMod Massmsg > &fArgument #1 must be an integer!");
                return;
            }
            new Thread(() -> {
                try {
                    int delay = Integer.parseInt(args[0]);
                    String command = utils.arrToStr(args, 1);
                    ArrayList<String> players = utils.getTabList();
                    for (int i = 0; i < players.size(); i++) {
                        utils.mc.thePlayer.sendChatMessage(
                                command.replace("%player%", players.get(i))
                                .replace("%rplayer%", utils.randomPlayer())
                        );
                        utils.sendMessage("&bWoahMod Massmsg > &fSent &b" + (i + 1) + "&f/&b" + players.size());
                        if (delay != 0) {
                            Thread.sleep(delay); }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    utils.sendMessage("&bWoahMod Massmsg > &fAn &cerror &foccurred. Check the logs for more details.");
                }
            }).start();
        }
    }

    @Override
    public String getCommandName() {
        return "massmsg";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "massmsg <delay in ms> <command>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
