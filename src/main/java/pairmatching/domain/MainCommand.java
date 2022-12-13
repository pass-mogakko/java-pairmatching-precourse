package pairmatching.domain;

import java.util.Arrays;

public enum MainCommand {
    MATCH_PAIRS("1", "페어 매칭"),
    SHOW_PAIRS("2", "페어 조회"),
    RESET_PAIRS("3", "페어 초기화"),
    QUIT("Q", "종료"),
    ;

    private String button;
    private String viewName;
//    private Consumer<Controller> method;

    MainCommand(String button, String viewName) {
        this.button = button;
        this.viewName = viewName;
//        this.method = method;
    }

    public String getButton() {
        return button;
    }

    public String getViewName() {
        return viewName;
    }

    public static MainCommand getCommand(String button) {
        return Arrays.stream(values())
                .filter(mainCommand -> button.equals(mainCommand.button))
                .findFirst()
                .orElse(null);
    }
}
