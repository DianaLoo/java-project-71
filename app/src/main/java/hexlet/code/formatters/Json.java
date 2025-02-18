package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

public class Json {
    public static String formatJson(List<Map<String, Object>> file) throws JsonProcessingException {
        DefaultPrettyPrinter pp = new MyPrettyPrinter();

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String jsonResult = mapper.writer(pp)
                    .writeValueAsString(file);
            jsonResult = jsonResult.replaceFirst("\\[" , "[\n");
            jsonResult = jsonResult.replaceAll("}, \\{", "  },\n  {");
            jsonResult = jsonResult.replace("} ]", "  }\n]");
            return jsonResult;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}




