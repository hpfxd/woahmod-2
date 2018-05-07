package xyz.tooger.woahmod2.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import xyz.tooger.woahmod2.misc.user.WoahModUser;

public class PlayerRenderHandler {
    @SubscribeEvent
    public void onRender(RenderPlayerEvent.Pre event) {
        EntityPlayer player = event.entityPlayer;
        WoahModUser user = new WoahModUser(player.getUniqueID().toString());
        if (user.upsideDown()) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, player.height + 0.1F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        }
    }

    @SubscribeEvent
    public void onRender(RenderPlayerEvent.Post event) {
        EntityPlayer player = event.entityPlayer;
        WoahModUser user = new WoahModUser(player.getUniqueID().toString());
        if (user.upsideDown()) {
            GL11.glTranslatef(0.0F, player.height + 0.1F, 0.0F);
            GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
        }
    }
}
