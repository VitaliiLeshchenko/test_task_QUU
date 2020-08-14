package serviceTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import solution.services.InputReaderService;
import solution.services.OutputWriterService;
import solution.services.impl.InputReaderServiceFile;
import solution.services.impl.OutputWriterServiceFile;

public class InputOutputServicesFileTest {

    private InputReaderService inputReaderService;
    private OutputWriterService outputWriterService;

    @Before
    public void initialize() {
        Path testFile = Paths.get("src/main/resources/testFile.txt");
        inputReaderService = new InputReaderServiceFile(testFile);
        outputWriterService = new OutputWriterServiceFile(testFile);
    }


    @Test
    public void write_and_read_file() {
        List<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("321");

        outputWriterService.write(expected);
        List<String> actual = inputReaderService.getInputData();
        Assert.assertEquals(expected, actual);
    }
}
