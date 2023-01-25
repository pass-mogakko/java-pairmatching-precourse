package pairmatching.view.menu;

import java.util.Arrays;
import java.util.Objects;
import pairmatching.view.constants.ErrorMessage;

public enum MenuCommand {
    MATCH("1"),
    READ("2"),
    RESET("3"),
    QUIT("Q");

    private final String key;

    MenuCommand(String key) {
        this.key = key;
    }

    public static MenuCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.key, key))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_COMMAND);
                });
    }

    public String getKey() {
        return key;
    }
}
