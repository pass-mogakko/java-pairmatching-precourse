package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Constant;

public class CrewGroup {

    private final List<Crew> crews = new ArrayList<>();

    public void initBackendCrews(String backendCrews) {
        Arrays.stream(backendCrews.split(Constant.CREW_SPLIT_REGEX))
                .forEach(crewName -> addCrew(Course.BACKEND, crewName));
    }

    public void initFrontendCrews(String frontendCrews) {
        Arrays.stream(frontendCrews.split(Constant.CREW_SPLIT_REGEX))
                .forEach(crewName -> addCrew(Course.FRONTEND, crewName));
    }

    private void addCrew(Course course, String crewName) {
        Crew crew = new Crew(course, crewName);
        crews.add(crew);
    }

    public List<String> findAllBackendCrewNames() {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(Course.BACKEND))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public List<String> findAllFrontendCrewNames() {
        return crews.stream()
                .filter(crew -> crew.isSameCourse(Course.FRONTEND))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

}
