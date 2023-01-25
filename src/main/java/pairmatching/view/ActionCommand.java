package pairmatching.view;

import java.util.Arrays;
import java.util.Objects;
import pairmatching.view.constants.ErrorMessage;

public enum ActionCommand {
    YES("네"),
    NO("아니오");

    private final String key;

    ActionCommand(String key) {
        this.key = key;
    }

    public static ActionCommand find(String key) {
        return Arrays.stream(values())
                .filter(value -> Objects.equals(value.key, key))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_COMMAND);
                });
    }
}
