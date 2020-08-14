package solution.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import solution.services.InputReaderService;
import static solution.utils.Constants.MAX_COUNT_OF_ALL_LINES;

public class InputReaderServiceTerminal implements InputReaderService {

    @Override
    public List<String> getInputData() {
        List<String> lines = new ArrayList<>();

        try(Scanner scanner = new Scanner(System.in)) {
            int lineCounter = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < lineCounter || i > MAX_COUNT_OF_ALL_LINES; i++) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }
}
