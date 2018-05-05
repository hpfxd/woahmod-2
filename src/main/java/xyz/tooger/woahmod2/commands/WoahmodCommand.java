package xyz.tooger.woahmod2.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import xyz.tooger.woahmod2.WoahMod;
import xyz.tooger.woahmod2.utils;

public class WoahmodCommand extends CommandBase {
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            if (args[0].equals("commands")) {
                utils.sendMessage("&b&m" + utils.br());
                utils.sendMessage("&bCommands");
                utils.sendMessage("&f");
                utils.sendMessage("&f/woahmod &b- &fMain woahmod command.");
                utils.sendMessage("&f/massmsg &b- &fRun a command once for everybody on the server.");
                utils.sendMessage("&b&m" + utils.br());
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
        utils.sendMessage("&b&m" + utils.br());
        utils.sendMessage("&fYou are using &bWoahMod 2 &fv&b" + WoahMod.VERSION + " &fby &bhpfxd");
        utils.sendMessage("&f");
        utils.sendMessage("&fUse &b/woahmod commands &ffor a list of commands!");
        utils.sendMessage("&b&m" + utils.br());
    }
}
