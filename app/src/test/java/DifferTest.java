import org.junit.jupiter.api.BeforeAll;
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
    @BeforeAll
    public static void readResult() throws Exception {
        expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/result.json")));
    }
    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testToJson(String type) throws Exception {
        var actual = Differ.generate("file1." + type, "file2." + type, "json");
        assertEquals(expectedJson, actual);
    }
}