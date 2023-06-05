package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JsonTest {
    @ParameterizedTest
    @CsvSource({
            "{\"Content\":\"New Item\"},{\"Content\":\"New Item\"},true",
            "{\"Content\":\"New Item\"},{\"Content\":\"New Ite\"},false",
            "{\"Content\":\"New Item\"},{\"Contet\":\"New Ite\"},false",
            "{\"Content\":\"ignore\"},{\"Content\":\"New Ite\"},true",
            "{\"Content\":\"New Item\"},{},false",
            "{},{\"Content\":\"New Item\"},false",
            "{},{},true",

    })
    public void verifyCompareJson(String json1, String json2, boolean expected) throws JsonProcessingException {
        CompareJson compareJson = new CompareJson();
        boolean actual = compareJson.compareJson(json1,json2);
        assert actual == expected;

    }
}
