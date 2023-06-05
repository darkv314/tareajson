package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CompareJson {
    public CompareJson(){};

    public boolean compareJson(String json1, String json2) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> type = new TypeReference<HashMap<String, Object>>() {};

        Map<String, Object> leftMap = mapper.readValue(json1, type);
        Map<String, Object> rightMap = mapper.readValue(json2, type);

        MapDifference<String, Object> difference = Maps.difference(leftMap, rightMap);
        Map<String, Object> onlyOnLeft = difference.entriesOnlyOnLeft();
        Map<String, Object> onlyOnRight = difference.entriesOnlyOnRight();
        int count = 0;
        if(difference.areEqual()){
            System.out.println("Both jsons are equal");
        }
        else {

            System.out.println("Entries only on left: " + onlyOnLeft);
            System.out.println("Entries only on right: " + onlyOnRight);
            for (Map.Entry<String, MapDifference.ValueDifference<Object>> entry : difference.entriesDiffering().entrySet()) {
                String key = entry.getKey();
                MapDifference.ValueDifference<Object> valueDiff = entry.getValue();

                Object leftValue = valueDiff.leftValue();
                Object rightValue = valueDiff.rightValue();
                if(leftValue.toString().startsWith("ignore") || rightValue.toString().startsWith("ignore")){
                    count++;
                    continue;
                }
                System.out.println("Key: " + key);
                System.out.println("Left Value: " + leftValue);
                System.out.println("Right Value: " + rightValue);
            }
            if(count == difference.entriesDiffering().size()){
                System.out.println("Both jsons are equal");
            }
            else {
                System.out.println("Both jsons are not equal");
            }
        }
        boolean areEqual = difference.areEqual();
        if(count >0 && count == difference.entriesDiffering().size()){
            areEqual = true;
        }
        System.out.println("\n");
        return areEqual;
    }
}
