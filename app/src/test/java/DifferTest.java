import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String expectedJson;
    private static String expectedStylish;
    private static String expectedPlain;
    @BeforeAll
    public static void readResult() throws Exception {

        expectedJson = Files.readString(Paths.get("src/test/resources/result.json")).trim();
        expectedStylish = Files.readString(Paths.get("src/test/resources/resultStylish")).trim();
        expectedPlain = Files.readString(Paths.get("src/test/resources/resultPlain")).trim();

    }
    @Test
    public void testToJsonInJson() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "json");
        assertEquals(expectedJson, actual);
    }
    @Test
    public void testToYamlInJson() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.yaml", "src/test/resources/file2.yaml", "json");
        assertEquals(expectedJson, actual);
    }
    @Test
    public void testToJsonInStylish() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish");
        assertEquals(expectedStylish, actual);
    }
    @Test
    public void testToYamlInStylish() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.yaml", "src/test/resources/file2.yaml", "stylish");
        assertEquals(expectedStylish, actual);
    }
    @Test
    public void testToJsonInPlain() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "plain");
        assertEquals(expectedPlain, actual);
    }
    @Test
    public void testToYamlInPlain() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.yaml", "src/test/resources/file2.yaml", "plain");
        assertEquals(expectedPlain, actual);
    }
    @Test
    public void testToJson() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json");
        assertEquals(expectedStylish, actual);
    }
    @Test
    public void testToYaml() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.yaml", "src/test/resources/file2.yaml");
        assertEquals(expectedStylish, actual);
    }
}