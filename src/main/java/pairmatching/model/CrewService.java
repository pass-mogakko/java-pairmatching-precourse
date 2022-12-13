package pairmatching.model;

import java.util.List;
import pairmatching.model.domain.Course;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.CrewRepository;

public class CrewService {

    public List<Crew> findAllCrewsByCourse(String courseName) {
        Course course = Course.findByName(courseName);
        return CrewRepository.findCrewsByCourse(course);
    }
}
