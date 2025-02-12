import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Path;
import java.nio.file.Paths;

import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String expectedJson;
    private static String expectedYaml;
    @BeforeAll
    public static void readResult() throws Exception {

        expectedJson = Files.readString(Paths.get("src/test/resources/result.json")).trim();
        expectedYaml = Files.readString(Paths.get("src/test/resources/result.yaml")).trim();
    }
    @Test
    public void testToJson() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "json");
        assertEquals(expectedJson, actual);
    }
    @Test
    public void testToYaml() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.yaml", "src/test/resources/file2.yaml", "json");
        assertEquals(expectedYaml, actual);
    }
    @Test
    public void testToStylish() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "json");
        assertEquals(expectedJson, actual);
    }
}