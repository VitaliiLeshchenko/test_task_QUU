package solution.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import solution.services.OutputWriterService;

public class OutputWriterServiceFile implements OutputWriterService {

    private final String path;

    public String getPath() {
        return path;
    }

    public OutputWriterServiceFile(String path) {
        this.path = path;
    }

    @Override
    public void write(List<String> strings) {
        try {
            Files.write(Paths.get(path), strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
