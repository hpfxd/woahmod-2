package xyz.tooger.woahmod2;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ChatComponentText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    public static String randomPlayer() {
        ArrayList<String> players = getTabList();
        return players.get(new Random().nextInt(players.size()));
    }

    public static String arrToStr(String[] arr, int startFrom) {
        StringBuilder sb = new StringBuilder();
        for (int i = startFrom; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }

        return sb.toString().trim();
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) {
        try {
            URLConnection conn = new URL(url).openConnection();
            conn.addRequestProperty("User-Agent", "WoahMod v" + WoahMod.VERSION);
            conn.setDoInput(true);
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static JSONArray readJsonArrayFromUrl(String url) {
        try {
            URLConnection conn = new URL(url).openConnection();
            conn.addRequestProperty("User-Agent", "WoahMod v" + WoahMod.VERSION);
            conn.setDoInput(true);
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }
}
