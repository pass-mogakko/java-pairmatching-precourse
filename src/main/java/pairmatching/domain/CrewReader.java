package pairmatching.domain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CrewReader {
    private static final String BACKEND_FILE = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE = "src/main/resources/frontend-crew.md";

    public List<List<String>> readAllFile() {
        List<String> backendCrews = readFile(BACKEND_FILE);
        List<String> frontendCrews = readFile(FRONTEND_FILE);
        return List.of(backendCrews, frontendCrews);
    }

    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
//            OutputView.printError(e);
        }
        return lines;
    }
}
