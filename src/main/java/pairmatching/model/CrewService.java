package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.domain.Course;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.CrewRepository;

public class CrewService {

    public List<String> findAllCrewNamesByCourse(String courseName) {
        Course course = Course.findByName(courseName);
        List<Crew> crews = CrewRepository.findCrewsByCourse(course);
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
