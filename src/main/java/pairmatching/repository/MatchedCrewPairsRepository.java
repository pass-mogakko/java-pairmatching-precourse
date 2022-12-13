package pairmatching.repository;

import pairmatching.domain.crew.MatchedCrewPairs;
import pairmatching.domain.woowacourse.Course;
import pairmatching.domain.woowacourse.Level;
import pairmatching.domain.woowacourse.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatchedCrewPairsRepository {
    private static final List<MatchedCrewPairs> matchedCrewPairs = new ArrayList<>();

    public static Optional<MatchedCrewPairs> findByOptions(Course course, Level level, Mission mission) {
        return matchedCrewPairs.stream()
                .filter(matchedCrewPairs -> matchedCrewPairs.isPresentByOptions(course, level,mission))
                .findFirst();
    }
}
