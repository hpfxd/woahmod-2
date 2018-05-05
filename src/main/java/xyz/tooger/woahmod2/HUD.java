package xyz.tooger.woahmod2;


import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD {
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        this.drawLine("&bWoahMod &fv&b" + WoahMod.VERSION, 15);
        this.drawLine("&c" + WoahMod.loadTag(utils.mc.thePlayer.getUniqueID().toString()) + utils.mc.thePlayer.getName(), 25);
    }

    private void drawLine(String text, int y) {
        FontRenderer fr = utils.mc.fontRendererObj;
        fr.drawStringWithShadow(
                text.replace("&", "§"),
                10,
                y,
                0
        );
    }
}
