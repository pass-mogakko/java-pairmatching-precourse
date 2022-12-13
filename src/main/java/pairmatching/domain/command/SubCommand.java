package pairmatching.domain.command;

public enum SubCommand {
    YES("네"),
    NO("아니오");

    private String button;

    SubCommand(String button) {
        this.button = button;
    }
}
