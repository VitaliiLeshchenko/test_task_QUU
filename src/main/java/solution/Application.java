package solution;

import java.util.List;
import solution.services.GeneralParser;
import solution.services.InputReaderService;
import solution.services.IoCContainer;
import solution.services.OutputWriterService;
import solution.services.impl.IoCContainerImpl;

public class Application {

    private static final IoCContainer ioCContainer = IoCContainerImpl.getInstance();
    private final InputReaderService inputReaderService;
    private final OutputWriterService outputWriterService;
    private final GeneralParser generalParser;


    public Application() {
        inputReaderService = ioCContainer.getInputReaderService();
        outputWriterService = ioCContainer.getOutputWriterService();
        generalParser = ioCContainer.getGeneralParser();
    }

    public void start() {
        outputWriterService.write(generalParser.parse(inputReaderService.getInputData()));
    }
}
