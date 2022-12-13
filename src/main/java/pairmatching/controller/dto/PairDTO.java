package pairmatching.controller.dto;

import java.util.List;

public class PairDTO {
    private final List<String> crewNames;

    public PairDTO(List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public List<String> getCrewNames() {
        return crewNames;
    }
}
