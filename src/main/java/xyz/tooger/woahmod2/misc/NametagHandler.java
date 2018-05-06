package xyz.tooger.woahmod2.misc;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import xyz.tooger.woahmod2.WoahMod;

public class NametagHandler {
    @SubscribeEvent
    public void modifyName(PlayerEvent.NameFormat event) {
        event.displayname = WoahMod.loadTag(
                event.entityPlayer.getUniqueID().toString()
        ).replace("&", "§") + event.username;
    }

    @SubscribeEvent
    public void joinServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        new Thread(WoahMod::reloadTags).start();
    }
}
