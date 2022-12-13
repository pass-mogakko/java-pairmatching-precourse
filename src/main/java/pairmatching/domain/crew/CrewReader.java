package pairmatching.domain.crew;

import pairmatching.domain.woowacourse.Course;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewReader {
    private static final String BACKEND_FILE = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE = "src/main/resources/frontend-crew.md";

    private final Map<Course, String> pathConverter = new HashMap<>();

    public CrewReader() {
        pathConverter.put(Course.BACKEND, BACKEND_FILE);
        pathConverter.put(Course.FRONTEND, FRONTEND_FILE);
    }

    public List<String> readFile(Course course) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(pathConverter.get(course));
            lines = Files.readAllLines(path);
        } catch (IOException e) {
//            OutputView.printError(e);
        }
        return lines;
    }
}
