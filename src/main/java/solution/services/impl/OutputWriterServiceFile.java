package solution.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import solution.services.OutputWriterService;

public class OutputWriterServiceFile implements OutputWriterService {

    private final Path path;

    public Path getPath() {
        return path;
    }

    public OutputWriterServiceFile(Path path) {
        this.path = path;
    }

    @Override
    public void write(List<String> strings) {
        try {
            Files.write(path, strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
