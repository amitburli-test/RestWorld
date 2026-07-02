package testcases;

import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Practice {

    @Test
    public void p1(){
        String s="{\n" +
                "  \"company\": \"TechSoft\",\n" +
                "  \"location\": \"Mumbai\",\n" +
                "  \"employees\": [\n" +
                "    {\n" +
                "      \"id\": 101,\n" +
                "      \"name\": \"Amit\",\n" +
                "      \"skills\": [\"Java\", \"Selenium\", \"REST Assured\"],\n" +
                "      \"address\": {\n" +
                "        \"city\": \"Mumbai\",\n" +
                "        \"pincode\": \"400001\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 102,\n" +
                "      \"name\": \"Rahul\",\n" +
                "      \"skills\": [\"Python\", \"API Testing\"],\n" +
                "      \"address\": {\n" +
                "        \"city\": \"Pune\",\n" +
                "        \"pincode\": \"411001\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        System.out.println(s);
        JsonPath js=new JsonPath(s);
        String com=js.get("company");
        int id=js.get("employees[0].id");
        String skill=js.get("employees[0].skills[1]");
        System.out.println(id+";;;;;;");
        System.out.println(skill+";;;;;;");
        System.out.println(com);
        int size=js.get("employees.size()");
        for(int i=0;i<size;i++) {
            List<String> f = js.get("employees[" + i + "].skills");
            System.out.println(f +"---");
        }

        System.out.println("\n++++++++++++++++++++++++\n");

        JSONObject ja=new JSONObject(s);
        System.out.println(ja.get("company"));
        System.out.println(ja.getJSONArray("employees").getJSONObject(0).get("id").toString());
        for(int i=0;i<ja.getJSONArray("employees").length();i++){
            String f = ja.getJSONArray("employees").getJSONObject(i).getJSONArray("skills").get(1).toString();
            JSONArray e = ja.getJSONArray("employees").getJSONObject(i).getJSONArray("skills");
            String n=ja.getJSONArray("employees").getJSONObject(i).get("name").toString();
            System.out.println(f);
            System.out.println(e);
            System.out.println(n);
        }
    }
}
