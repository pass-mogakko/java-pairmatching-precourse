package pairmatching.model.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import pairmatching.model.util.FileTextParser;

public class CrewRepository {
    private static final String CREW_BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String CREW_FRONTEND_PATH = "src/main/resources/frontend-crew.md";
    private static final List<Crew> crews = new ArrayList<>();

    static {
        try {
            List<String> crewBackend = FileTextParser.readTextLines(CREW_BACKEND_PATH);
            crewBackend.forEach(crewName -> CrewRepository.addCrew(new Crew(Course.BACKEND, crewName)));
            List<String> crewFrontend = FileTextParser.readTextLines(CREW_FRONTEND_PATH);
            crewFrontend.forEach(crewName -> CrewRepository.addCrew(new Crew(Course.FRONTEND, crewName)));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static List<Crew> findCrewsByCourse(Course course) {
        return crews.stream()
                .filter(crew -> Objects.equals(crew.getCourse(), course))
                .collect(Collectors.toList());
    }
}
