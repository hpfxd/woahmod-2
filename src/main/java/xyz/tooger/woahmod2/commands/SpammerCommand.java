package xyz.tooger.woahmod2.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import xyz.tooger.woahmod2.utils;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

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
        } else if (args[0].equals("file")) {
            if (args.length == 3 || args.length == 5) {
                try {
                    Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    utils.sendMessage("&bWoahMod Spammer > &fArgument #2 must be an integer!");
                    return;
                }
                File file = new File(utils.mc.mcDataDir, "mods/woahmod/spammerfiles/" + args[2]);
                if (!file.exists()) {
                    utils.sendMessage("&bWoahMod Spammer > &f" + args[2] + " does not exist.");
                    utils.sendMessage("&bWoahMod Spammer > &fRead more on &bhttps://woahmod.tooger.xyz/&f!");
                    return;
                }

                new Thread(() -> {
                    try {
                        int delay = Integer.parseInt(args[1]);
                        List<String> lines = Files.readAllLines(file.toPath());
                        for (int i = 0; i < lines.size(); i++) {
                            if (args.length == 3) {
                                utils.mc.thePlayer.sendChatMessage(lines.get(i));
                            } else {
                                if (args[3].equals("-p")) {
                                    utils.mc.thePlayer.sendChatMessage(lines.get(i).replace("%p%", args[4]));
                                } else {
                                    utils.mc.thePlayer.sendChatMessage(lines.get(i));
                                }
                            }
                            utils.sendMessage("&bWoahMod Spammer > &fSent &b" + (i + 1) + "&f/&b" + lines.size());
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
            } else {
                utils.sendMessage("&bWoahMod Spammer > &fInvalid argument count.");
            }
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
