package json;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Test {
    public static void main(String Args[]) throws JsonProcessingException {
        String json1 = "{\"id\":1,\"name\":\"Paul\",\"lastName\":\"Landaeta\",\"company\":\"Mojix\"}";
        String json2 = "{\"id\":2,\"name\":\"Alexis\",\"lastName\":\"Marechal\",\"company\":\"UPB\"}";
        CompareJson compareJson = new CompareJson();
        boolean actual = compareJson.compareJson(json1,json2);
        System.out.println(actual);
    }
}
