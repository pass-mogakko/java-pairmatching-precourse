package pairmatching.controller;

import pairmatching.model.CrewService;

public class PairMatchingController {
    private final CrewService crewService = new CrewService();

    public void execute() {
        setUp();
    }

    private void setUp() {
        crewService.importCrewResources();
    }
}
