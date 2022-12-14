package pairmatching.controller.dto;

import java.util.List;

public class LevelDTO {
    private final String name;
    private final List<String> missions;

    public LevelDTO(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }
}
