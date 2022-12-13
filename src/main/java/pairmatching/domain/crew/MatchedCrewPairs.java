package pairmatching.domain.crew;

import pairmatching.domain.woowacourse.Course;
import pairmatching.domain.woowacourse.Level;
import pairmatching.domain.woowacourse.Mission;

import java.util.List;

public class MatchedCrewPairs {
    private Course course;
    private Level level;
    private Mission mission;
    private List<Crew> crews;

    public MatchedCrewPairs(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public boolean isPresentByOptions(Course course, Level level, Mission mission) {
        return (this.course.equals(course)
                && this.level.equals(level)
                && this.mission.equals(mission));
    }

}
