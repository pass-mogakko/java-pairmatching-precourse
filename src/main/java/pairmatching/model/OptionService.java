package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.controller.dto.LevelDTO;
import pairmatching.controller.dto.OptionDTO;
import pairmatching.model.domain.Course;
import pairmatching.model.domain.Level;

public class OptionService {
    public OptionDTO getAllOptions() {
        return new OptionDTO(getAllCourseNames(), getAllLevelMissions());
    }

    private List<String> getAllCourseNames() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    private List<LevelDTO> getAllLevelMissions() {
        return Arrays.stream(Level.values())
                .map(level -> new LevelDTO(level.getName(), level.getMissions()))
                .collect(Collectors.toList());
    }
}
