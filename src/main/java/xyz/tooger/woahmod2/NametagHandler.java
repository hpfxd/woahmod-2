package xyz.tooger.woahmod2;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class NametagHandler {
    @SubscribeEvent
    public void modifyName(PlayerEvent.NameFormat event) {
        event.displayname = WoahMod.loadTag(
                event.entityPlayer.getUniqueID().toString()
        ) + event.username;
    }

    @SubscribeEvent
    public void joinServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        WoahMod.reloadTags();
    }
}
