package solution.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import solution.services.InputReaderService;

public class InputReaderServiceFile implements InputReaderService {

    private final String path;

    public InputReaderServiceFile(String path) {
        this.path = path;
    }


    public List<String> getInputData() {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(Paths.get(path));
            strings.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
