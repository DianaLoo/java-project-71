package hexlet.code;

import java.io.IOException;
import java.util.Map;
//import java.nio.file.Paths;
//import java.nio.file.Files;
//import java.util.List;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import hexlet.code.cnst.Type;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    public static Map<String, Object> parse(String content, String format) throws IOException {
        //парсим файл. вызвать две разные библиотеки
        // смотря какой формат будет передан,нужно выбрать один из разных парсеров которые уже там и их распарсить

        ObjectMapper mapper = switch (format) {
            case "json" -> new ObjectMapper();
            case "yaml", "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new UnsupportedOperationException();
        };
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }
}