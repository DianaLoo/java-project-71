package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Contrast {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        List<Map<String, Object>> result = new ArrayList<>();

        var dongles = new TreeSet<>(file1.keySet());
        dongles.addAll(file2.keySet());

        for (String key : dongles) {
            Map<String, Object> difference = new HashMap<>();
            Object value1 = file1.get(key);
            Object value2 = file2.get(key);
            difference.put("key", key);
            if (file1.containsKey(key) && file2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    difference.put("status", "unchanged");
                    difference.put("value1", value1);
                    difference.put("value2", value2);
                } else {
                    difference.put("status", "changed");
                    difference.put("value1", value1);
                    difference.put("value2", value2);
                }
            } else if (file1.containsKey(key)) {
                difference.put("status", "removed");
                difference.put("value1", value1);
                difference.put("value2", null);
            } else if (file2.containsKey(key)) {
                difference.put("status", "added");
                difference.put("value1", null);
                difference.put("value2", value2);
            }
            result.add(difference);
        }
        return result;
    }
}

