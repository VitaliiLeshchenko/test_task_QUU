package solution.services.impl;

import java.util.List;
import solution.services.OutputWriterService;

public class OutputWriterServiceTerminal implements OutputWriterService {

    @Override
    public void write(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
