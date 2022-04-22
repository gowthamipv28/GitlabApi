package gitlb.payloads;

public class PayloadAddMember {
    public static String addMember(){
        return "{\r\n" +
                "    \"user_id\":\"11326359\",\n" +
                "    \"access_level\":\"30\"\r\n" +
                "}";
    }
    public static String createVariable(){
        return "{\n" +
                "    \"variable_type\": \"env_var\",\n" +
                "    \"key\": \"Test\",\n" +
                "    \"value\": \"new value\",\n" +
                "    \"protected\": false,\n" +
                "    \"masked\": false,\n" +
                "    \"environment_scope\": \"*\"\n" +
                "}";
    }
}
