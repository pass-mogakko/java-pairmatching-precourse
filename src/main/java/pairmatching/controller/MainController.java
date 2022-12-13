package pairmatching.controller;

import pairmatching.domain.CrewReader;
import pairmatching.service.MainService;

import java.util.List;

public class MainController {
    private final MainService mainService = new MainService();

    public MainController() {
        setUp();
    }

    private void setUp() {
        CrewReader crewReader = new CrewReader();
        List<List<String>> crewNames = crewReader.readAllFile();
//        mainService.setUpCrewNames(crewNames);

    }

    public void run() {

    }

}
