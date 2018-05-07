package xyz.tooger.woahmod2.misc.user;


import org.json.JSONObject;
import xyz.tooger.woahmod2.WoahMod;
import xyz.tooger.woahmod2.utils;

public class WoahModUser {
    private String uuid = "";

    public WoahModUser() {}
    public WoahModUser(String uuid) {
        this.uuid = uuid.replace("-", "");
    }

    public String getUUID() {
        return this.uuid;
    }

    public WoahModUser update() {
        WoahMod.users = utils.readJsonFromUrl("https://woahmod.tooger.xyz/users.json");
        return this;
    }

    public boolean hasTag() {
        return getObject().has("tag");
    }

    public String getTag() {
        return hasTag() ? getObject().getString("tag") : "";
    }

    public boolean upsideDown() {
        return getObject().has("upsideDown") && getObject().getBoolean("upsideDown");
    }

    public boolean userExists() {
        return WoahMod.users.has(this.uuid);
    }

    private JSONObject getObject() {
        return userExists() ? WoahMod.users.getJSONObject(this.uuid) : new JSONObject();
    }
}
