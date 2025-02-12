package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatterForm(List<Map<String, Object>> file, String format) {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(file);
            case "json":
                return Json.formatJson(file);
            case "plain":
                return Plain.formatPlain(file);
            default:
                return Stylish.formatStylish(file);
        }
    }
}
