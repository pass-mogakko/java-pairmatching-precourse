package pairmatching.domain.command;

import pairmatching.controller.MainController;

import java.util.Arrays;
import java.util.function.Consumer;

public enum MainCommand {
    MATCH_PAIRS("1", "페어 매칭", MainController::matchPairs),
    SHOW_PAIRS("2", "페어 조회", MainController::showPairs),
    RESET_PAIRS("3", "페어 초기화", MainController::resetPairs),
    QUIT("Q", "종료", MainController::quit);

    private String button;
    private String viewName;
    private Consumer<MainController> method;

    MainCommand(String button, String viewName, Consumer<MainController> method) {
        this.button = button;
        this.viewName = viewName;
        this.method = method;
    }

    public String getButton() {
        return button;
    }

    public String getViewName() {
        return viewName;
    }

    public static MainCommand convert(String button) {
        return Arrays.stream(values())
                .filter(mainCommand -> button.equals(mainCommand.button))
                .findFirst()
                .orElse(null);
    }

    public void execute(MainController mainController) {
        method.accept(mainController);
    }
}
