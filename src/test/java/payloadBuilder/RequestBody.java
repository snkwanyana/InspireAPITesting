package payloadBuilder;

import org.json.simple.JSONObject;

public class RequestBody {

    public static JSONObject updateEmail(String email) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        return requestBody;
    }

    public static JSONObject deleteLastname(String lastname) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("last_name", lastname);
        return requestBody;
    }
}
