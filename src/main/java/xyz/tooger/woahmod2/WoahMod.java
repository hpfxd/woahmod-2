package xyz.tooger.woahmod2;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.tooger.woahmod2.commands.MassmsgCommand;
import xyz.tooger.woahmod2.commands.SpammerCommand;
import xyz.tooger.woahmod2.commands.WoahmodCommand;
import xyz.tooger.woahmod2.misc.HUD;
import xyz.tooger.woahmod2.misc.NametagHandler;
import xyz.tooger.woahmod2.misc.UpdateAlerter;

@Mod(modid = WoahMod.MODID, version = WoahMod.VERSION)
public class WoahMod {
    static final String MODID = "woahmod-2";
    public static final String VERSION = "0.5";
    private static JSONObject tags = new JSONObject();
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new WoahmodCommand());
        ClientCommandHandler.instance.registerCommand(new MassmsgCommand());
        ClientCommandHandler.instance.registerCommand(new SpammerCommand());

        MinecraftForge.EVENT_BUS.register(new HUD());
        MinecraftForge.EVENT_BUS.register(new NametagHandler());
        MinecraftForge.EVENT_BUS.register(new UpdateAlerter());
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

    public static JSONObject updates() {
        JSONArray json = utils.readJsonArrayFromUrl("https://api.github.com/repos/hpfxd/woahmod-2/releases");
        if (json.length() != 0) {
            System.out.println("Latest WoahMod version is " + json.getJSONObject(0).getString("tag_name"));
            return json.getJSONObject(0);
        }
        return new JSONObject();
    }
}
