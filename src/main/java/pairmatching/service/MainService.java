package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

import java.util.List;

public class MainService {
    public void setUpCrewNames(Course course, List<String> crewNames) {
        crewNames.forEach(name -> CrewRepository.save(new Crew(course, name)));
    }
}
