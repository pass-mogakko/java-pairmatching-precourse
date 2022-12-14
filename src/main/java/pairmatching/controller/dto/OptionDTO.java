package pairmatching.controller.dto;

import java.util.List;

public class OptionDTO {
    private final List<String> courses;
    private final List<LevelDTO> levels;

    public OptionDTO(List<String> courses, List<LevelDTO> levels) {
        this.courses = courses;
        this.levels = levels;
    }

    public List<String> getCourses() {
        return courses;
    }

    public List<LevelDTO> getLevels() {
        return levels;
    }
}
