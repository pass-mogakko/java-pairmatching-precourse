package pairmatching.service;

import pairmatching.domain.crew.MatchedCrewPairs;
import pairmatching.domain.woowacourse.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.woowacourse.Level;
import pairmatching.domain.woowacourse.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchedCrewPairsRepository;

import java.util.List;
import java.util.Optional;

public class MainService {
    public void setUpCrewNames(Course course, List<String> crewNames) {
        crewNames.forEach(name -> CrewRepository.save(new Crew(course, name)));
    }

    public boolean checkIfRecentLogExists(List<Object> options) {
        Course course = (Course) options.get(0);
        Level level = (Level) options.get(1);
        Mission mission = (Mission) options.get(2);

        Optional<MatchedCrewPairs> recentLog = MatchedCrewPairsRepository.findByOptions(course, level, mission);
        return (recentLog.isPresent());
    }

    public void matchPairs(List<Object> options) {
        Course course = (Course) options.get(0);
        Level level = (Level) options.get(1);
        Mission mission = (Mission) options.get(2);


    }
}
