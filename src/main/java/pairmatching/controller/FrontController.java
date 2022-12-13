package pairmatching.controller;

import pairmatching.model.CrewService;
import pairmatching.view.InputView;

public class FrontController {
    private final CrewService crewService = new CrewService();

    public void execute() {
        setUp();
        System.out.println(InputView.inputMenuCommand());
    }

    private void setUp() {
        crewService.importCrewResources();
    }
}
