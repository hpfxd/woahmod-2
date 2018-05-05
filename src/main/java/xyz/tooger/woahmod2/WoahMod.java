package xyz.tooger.woahmod2;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.tooger.woahmod2.commands.MassmsgCommand;
import xyz.tooger.woahmod2.commands.WoahmodCommand;

@Mod(modid = WoahMod.MODID, version = WoahMod.VERSION)
public class WoahMod {
    static final String MODID = "woahmod-2";
    public static final String VERSION = "0.4";
    public static JSONObject tags = new JSONObject();
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new WoahmodCommand());
        ClientCommandHandler.instance.registerCommand(new MassmsgCommand());

        MinecraftForge.EVENT_BUS.register(new HUD());
        MinecraftForge.EVENT_BUS.register(new NametagHandler());
    }

    public static void reloadTags() {
        tags = utils.readJsonFromUrl("https://hpfxd.tooger.xyz/woahmod-2/tags.json");
    }

    public static String loadTag(String uuid) {
        String uuidfix = uuid.replace("-", "");
        if (tags.has(uuidfix)) {
            return tags.getString(uuidfix);
        } else {
            return "";
        }
    }
}
