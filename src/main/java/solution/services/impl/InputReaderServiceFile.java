package solution.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import solution.services.InputReaderService;

public class InputReaderServiceFile implements InputReaderService {

    private final Path path;

    public InputReaderServiceFile(Path path) {
        this.path = path;
    }


    public List<String> getInputData() {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
