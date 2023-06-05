package json;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Test {
    public static void main(String Args[]) throws JsonProcessingException {
        String json1 = "{\n" +
                "      \"item\": {\n" +
                "        \"name\": \"test\"\n" +
                "      }\n" +
                "    }";
        String json2 = "{\n" +
                "      \"item\": {\n" +
                "        \"name\": \"tet\"\n" +
                "      }\n" +
                "    }";
        CompareJson compareJson = new CompareJson();
        boolean actual = compareJson.compareJson(json1,json2);
        System.out.println(actual);
    }
}
