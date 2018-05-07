package xyz.tooger.woahmod2.misc;


import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.tooger.woahmod2.WoahMod;
import xyz.tooger.woahmod2.misc.user.WoahModUser;
import xyz.tooger.woahmod2.utils;

public class HUD {
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) {
        this.drawLine(
                "&bWoahMod &fv&b" + WoahMod.VERSION,
                5
        );
        this.drawLine(
                "&c" + new WoahModUser(utils.mc.thePlayer.getUniqueID().toString()).getTag() + utils.mc.thePlayer.getName(),
                15
        );
    }

    private void drawLine(String text, int y) {
        FontRenderer fr = utils.mc.fontRendererObj;
        fr.drawStringWithShadow(
                text.replace("&", "§"),
                5,
                y,
                0
        );
    }
}
