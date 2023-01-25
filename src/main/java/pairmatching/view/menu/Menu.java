package pairmatching.view.menu;

public enum Menu {
    MATCH("페어 매칭", MenuCommand.MATCH),
    READ("페어 조회", MenuCommand.READ),
    RESET("페어 초기화", MenuCommand.RESET),
    QUIT("종료", MenuCommand.QUIT);

    private final String name;
    private final MenuCommand command;

    Menu(String name, MenuCommand command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public MenuCommand getCommand() {
        return command;
    }
}
