package pairmatching.controller;

import pairmatching.domain.woowacourse.Course;
import pairmatching.domain.crew.CrewReader;
import pairmatching.domain.command.MainCommand;
import pairmatching.service.MainService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

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
        executeByCommand(mainCommand);
    }

    private void executeByCommand(MainCommand mainCommand) {
        try {
            mainCommand.execute(this);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    public void matchPairs() {
        OutputView.printLevelAndMission();
        List<Object> options = handleInputException(InputView::readOptions);
        boolean firstMatching = mainService.checkIfRecentLogExists(options);
        if (firstMatching) {
            mainService.matchPairs(options);
        }
        if (!firstMatching) {}
    }

    public void showPairs() {}

    public void resetPairs() {}

    public void quit() {
        return;
    }

}
