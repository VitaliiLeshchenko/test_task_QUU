package serviceTest;

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
        String testFile = "src/main/resources/testFile.txt";
        inputReaderService = new InputReaderServiceFile(testFile);
        outputWriterService = new OutputWriterServiceFile(testFile);
    }


    @Test
    public void write_and_read_file() {
        List<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("line1");
        expected.add("line2");
        outputWriterService.write(expected);
        expected.remove(0);
        List<String> actual = inputReaderService.getInputData();
        Assert.assertEquals(expected, actual);
    }
}
