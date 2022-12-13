package pairmatching.view;

import pairmatching.domain.MainCommand;

import static pairmatching.util.ErrorMessage.COMMAND_NOT_FOUND;

public class InputValidator {
    static void validateMainCommand(String button) {
        if (MainCommand.getCommand(button) == null) {
            throw new IllegalArgumentException(COMMAND_NOT_FOUND);
        }
    }
}
