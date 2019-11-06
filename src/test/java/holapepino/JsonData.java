package holapepino;

import org.json.JSONObject;

public class JsonData {
    public static JSONObject data(){
        JSONObject o = new JSONObject();
        o.put("user_id", 1);
        o.put("name", "marino");
        o.put("address", "same");
        o.put("toen", 123456789);

        return o;
    }
}
