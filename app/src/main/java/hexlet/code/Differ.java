package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.lang.Exception;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String content1 = readFile(filePath1);
        String content2 = readFile(filePath2);

        String fileFormat1 = getFileType(filePath1);
        String fileFormat2 = getFileType(filePath2);

        //распарсили
        Map<String, Object> file1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> file2 = Parser.parse(content2, fileFormat2);
        return "";
    }

    public static String readFile(String filePath) throws Exception {
        //Читаем содержимое файла
        var path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }
    private static String getFileType(String filePath) {
        // возвращает расширение файла, split разделяем файл по точке
        String[] expansion = filePath.split("\\.");

        return expansion[expansion.length - 1];
    }
}
