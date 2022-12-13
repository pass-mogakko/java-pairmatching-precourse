package pairmatching.model;

import java.io.IOException;
import java.util.List;
import pairmatching.model.domain.Course;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.CrewRepository;
import pairmatching.model.util.FileTextParser;

public class CrewService {
    private static final String CREW_BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String CREW_FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    public void importCrewResources() {
        try {
            List<String> crewBackend = FileTextParser.readTextLines(CREW_BACKEND_PATH);
            crewBackend.forEach(crewName -> CrewRepository.addCrew(new Crew(Course.BACKEND, crewName)));
            List<String> crewFrontend = FileTextParser.readTextLines(CREW_FRONTEND_PATH);
            crewFrontend.forEach(crewName -> CrewRepository.addCrew(new Crew(Course.FRONTEND, crewName)));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
