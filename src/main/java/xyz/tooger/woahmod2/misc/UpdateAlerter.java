package xyz.tooger.woahmod2.misc;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.json.JSONObject;
import xyz.tooger.woahmod2.WoahMod;
import xyz.tooger.woahmod2.utils;

public class UpdateAlerter {
    @SubscribeEvent
    public void joinServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        new Thread(() -> {
            JSONObject updates = WoahMod.updates();
            if (!updates.getString("tag_name").equals(WoahMod.VERSION)) {
                utils.sendMessage("&b&m" + utils.br());
                utils.sendMessage("&cWoahMod");
                utils.sendMessage("&f");
                utils.sendMessage("&4NEW UPDATE");
                utils.sendMessage("&bYour version: &f" + WoahMod.VERSION);
                utils.sendMessage("&bNEW version: &f" + updates.getString("tag_name"));
                utils.sendMessage("&f");
                utils.sendMessage("&cUse &7/woahmod updates &cfor more info.");
                utils.sendMessage("&b&m" + utils.br());
            }
        });
    }
}
