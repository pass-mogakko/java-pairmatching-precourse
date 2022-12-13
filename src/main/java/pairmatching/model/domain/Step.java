package pairmatching.model.domain;

import java.util.Objects;
import pairmatching.model.constants.ErrorMessage;

public class Step {
    private final Course course;
    private final Level level;
    private final String mission;

    public Step(String courseName, String levelName, String missionName) {
        this.course = Course.findByName(courseName);
        this.level = Level.findByName(levelName);
        validateMission(missionName);
        this.mission = missionName;
    }

    private void validateMission(String missionName) {
        if (!level.hasMission(missionName)) {
            throw new IllegalArgumentException(ErrorMessage.MISSION_NOT_FOUND);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Step step = (Step) o;
        return course == step.course && level == step.level && Objects.equals(mission, step.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
