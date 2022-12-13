package pairmatching.service;

import pairmatching.domain.woowacourse.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.repository.CrewRepository;

import java.util.List;

public class MainService {
    public void setUpCrewNames(Course course, List<String> crewNames) {
        crewNames.forEach(name -> CrewRepository.save(new Crew(course, name)));
    }
}
