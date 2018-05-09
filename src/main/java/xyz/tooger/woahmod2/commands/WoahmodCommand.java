package xyz.tooger.woahmod2.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import org.json.JSONObject;
import xyz.tooger.woahmod2.WoahMod;
import xyz.tooger.woahmod2.misc.user.WoahModUser;
import xyz.tooger.woahmod2.utils;

public class WoahmodCommand extends CommandBase {
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            if (args[0].equals("commands")) {
                utils.sendMessage("&b&m" + utils.br());
                utils.sendMessage("&cCommands");
                utils.sendMessage("&f");
                utils.sendMessage("&f/woahmod &b- &fMain woahmod command.");
                utils.sendMessage("&f/massmsg <delay> <command> &b- &fRun a command once for everybody on the server.");
                utils.sendMessage("&f/spammer <delay> <amount> <command> &b- &fSpam a command x amount of times with a delay.");
                utils.sendMessage("&f/spammer file <delay> <file> [-p <player>] &b- &fSpam commands from a text file.");
                utils.sendMessage("&f");
                utils.sendMessage("&cUse &fhttps://woahmod.tooger.xyz &cfor more info.");
                utils.sendMessage("&b&m" + utils.br());
            } else if (args[0].equals("updates")) {
                new Thread(() -> {
                    JSONObject updates = WoahMod.updates();
                    if (!updates.getString("tag_name").equals(WoahMod.VERSION)) {
                        utils.sendMessage("&b&m" + utils.br());
                        utils.sendMessage("&4NEW UPDATE");
                        utils.sendMessage("&bYour version: &f" + WoahMod.VERSION);
                        utils.sendMessage("&bNEW version: &f" + updates.getString("tag_name"));
                        utils.sendMessage("&f");
                        utils.sendMessage("&bRelease notes:");
                        utils.sendMessage("&f");
                        utils.sendMessage("&7" + updates.getString("body").replace("\r", ""));
                        utils.sendMessage("&b&m" + utils.br());
                    } else {
                        utils.sendMessage("&bYou are up to date!");
                    }
                });
            } else {
                sendHelp();
            }
        } else {
            sendHelp();
        }
    }

    @Override
    public String getCommandName() {
        return "woahmod";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "woahmod";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    private void sendHelp() {
        WoahModUser user = new WoahModUser(utils.mc.thePlayer.getUniqueID().toString());
        utils.sendMessage("&b&m" + utils.br());
        utils.sendMessage("&fYou are using &bWoahMod 2 &fv&b" + WoahMod.VERSION + " &fby &bhpfxd");
        utils.sendMessage("&f");
        utils.sendMessage("&fHello &b" + utils.mc.thePlayer.getName() + "&f!");
        utils.sendMessage("&fCurrent tag: " + (user.hasTag() ? user.getTag() : "&bNone\n" +
                "&cRequest a tag in the Discord server!\n" +
                "&bdiscord.gg/KgwHHX2"));
        utils.sendMessage("&f");
        utils.sendMessage("&fUse &b/woahmod commands &ffor a list of commands!");
        utils.sendMessage("&b&m" + utils.br());
    }
}
