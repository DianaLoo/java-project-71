package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;


public class Json {
    public static String formatJson(List file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(file);
    }
}




