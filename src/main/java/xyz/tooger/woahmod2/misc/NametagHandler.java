package xyz.tooger.woahmod2.misc;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import xyz.tooger.woahmod2.misc.user.WoahModUser;

public class NametagHandler {
    @SubscribeEvent
    public void modifyName(PlayerEvent.NameFormat event) {
        WoahModUser user = new WoahModUser(event.entityPlayer.getUniqueID().toString());
        event.displayname = user.hasTag()
                ? user.getTag().replace("&", "§") + event.username
                : event.username;
    }

    @SubscribeEvent
    public void joinServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        new Thread(new WoahModUser()::update).start();
    }
}
