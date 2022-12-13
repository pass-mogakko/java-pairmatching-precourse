package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.CrewReader;
import pairmatching.domain.MainCommand;
import pairmatching.service.MainService;
import pairmatching.view.InputView;

import java.util.List;

import static pairmatching.util.ExceptionHandler.handleInputException;

public class MainController {
    private final MainService mainService = new MainService();

    public MainController() {
        setUp();
    }

    private void setUp() {
        CrewReader crewReader = new CrewReader();

        List<String> backendCrews = crewReader.readFile(Course.BACKEND);
        mainService.setUpCrewNames(Course.BACKEND, backendCrews);

        List<String> frontendCrews = crewReader.readFile(Course.FRONTEND);
        mainService.setUpCrewNames(Course.FRONTEND, frontendCrews);

    }

    public void run() {
        MainCommand mainCommand = handleInputException(InputView::readMainCommand);

    }

}
