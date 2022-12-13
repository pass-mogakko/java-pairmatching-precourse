package pairmatching.domain;

import java.util.List;

public class PairMatching {

    private final Course course;
    private final String level;
    private final String mission;
    private final List<String> crews;

    public PairMatching(Course course, String level, String mission, List<String> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }

    public boolean isSameCourse(Course course) {
        return this.course == course;
    }

    public boolean isSameLevel(String level) {
        return this.level.equals(level);
    }

    public boolean isSameMission(String mission) {
        return this.mission.equals(mission);
    }
}
