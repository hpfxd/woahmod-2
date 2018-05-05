package xyz.tooger.woahmod2;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.floor;

public class utils {
    public static Minecraft mc = Minecraft.getMinecraft();

    public static String br() {
        StringBuilder dashes = new StringBuilder();
        float chatWidth = mc.gameSettings.chatWidth;
        float chatScale = mc.gameSettings.chatScale;
        int numdash = (int) floor(((((280 * (chatWidth)) + 40) / 320) * (1 / chatScale)) * 53);
        for (int j = 0; j < numdash; j++) {
            dashes.append("-");
        }
        return dashes.toString();
    }

    public static void sendMessage(String msg) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(
                msg
                .replace("&", "§")
        ));
    }

    public static ArrayList<String> getTabList() {
        if (mc.isSingleplayer()) return new ArrayList<>(Collections.singletonList(mc.getSession().getUsername()));
        if (mc.getNetHandler() == null || mc.getNetHandler().getPlayerInfoMap() == null) return new ArrayList<>();

        ArrayList<String> playerNames = new ArrayList<>();

        for (NetworkPlayerInfo playerInfo : mc.getNetHandler().getPlayerInfoMap()) {
            playerNames.add(playerInfo.getGameProfile().getName());
        }

        return playerNames;
    }

    public static String arrToStr(String[] arr, int startFrom) {
        StringBuilder sb = new StringBuilder();
        for (int i = startFrom; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
