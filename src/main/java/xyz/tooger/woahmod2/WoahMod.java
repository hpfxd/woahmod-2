package xyz.tooger.woahmod2;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import xyz.tooger.woahmod2.commands.MassmsgCommand;
import xyz.tooger.woahmod2.commands.WoahmodCommand;

@Mod(modid = WoahMod.MODID, version = WoahMod.VERSION)
public class WoahMod {
    public static final String MODID = "woahmod-2";
    public static final String VERSION = "0.2";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new WoahmodCommand());
        ClientCommandHandler.instance.registerCommand(new MassmsgCommand());
    }
}
