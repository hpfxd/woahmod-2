package xyz.tooger.woahmod2.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import xyz.tooger.woahmod2.utils;

public class SpammerCommand extends CommandBase {
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length <= 1) {
            utils.sendMessage("&b&m" + utils.br());
            utils.sendMessage("&bSpammer");
            utils.sendMessage("&f");
            utils.sendMessage("&fSpams a command x amount of times with a delay.");
            utils.sendMessage("&f");
            utils.sendMessage("&bDelay");
            utils.sendMessage("&fThe delay is in milliseconds. This means that to make it a one second delay, you should use '1000'.");
            utils.sendMessage("&b&m" + utils.br());
        } else {
            try {
                Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                utils.sendMessage("&bWoahMod Spammer > &fArgument #1 must be an integer!");
                return;
            }
            new Thread(() -> {
                try {
                    int delay = Integer.parseInt(args[0]);
                    int amount = Integer.parseInt(args[1]);
                    String command = utils.arrToStr(args, 2);
                    for (int i = 0; i < amount; i++) {
                        utils.mc.thePlayer.sendChatMessage(command);
                        utils.sendMessage("&bWoahMod Spammer > &fSent &b" + (i + 1) + "&f/&b" + amount);
                        if (delay != 0) {
                            Thread.sleep(delay);
                        }
                    }
                } catch (NumberFormatException e) {
                    utils.sendMessage("&bWoahMod Spammer > &fInvalid arguments.");
                } catch (Exception e) {
                    e.printStackTrace();
                    utils.sendMessage("&bWoahMod Spammer > &fAn &cerror &foccurred. Check the logs for more details.");
                }
            }).start();
        }
    }

    @Override
    public String getCommandName() {
        return "spammer";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/spammer <delay> <amount> <command>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
