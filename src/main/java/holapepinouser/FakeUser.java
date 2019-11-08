package holapepinouser;

import org.json.JSONObject;

public class FakeUser {
    private static Integer user_id;
    private static String name;
    private static Integer Token;

    public static int getUserId(){
        JSONObject ob = new JsonData().data();
        user_id = ob.getInt("user_id");
        return user_id;
    }
    public static String getUserName(){
        JSONObject ob = new JsonData().data();
        name = ob.getString("name");
        return name;
    }
    public  static int getUserToken(){
        JSONObject ob = new JsonData().data();
        Token = ob.getInt("toen");
        return Token;
    }
}
