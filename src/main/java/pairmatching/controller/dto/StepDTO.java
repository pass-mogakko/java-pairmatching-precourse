package pairmatching.controller.dto;

public class StepDTO {
    private final String course;
    private final String level;
    private final String mission;

    public StepDTO(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }

    @Override
    public String toString() {
        return "StepDTO{" +
                "course='" + course + '\'' +
                ", level='" + level + '\'' +
                ", mission='" + mission + '\'' +
                '}';
    }
}
