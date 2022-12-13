package pairmatching.view;

import pairmatching.domain.MainCommand;

import java.util.Arrays;

public class MessageFactory {
    static final String COMMAND_REQUEST_MESSAGE = "기능을 선택하세요.";
    static final String COMMAND_FORM = "%s. %s";
    static final String ERROR_MESSAGE_FORM = "[ERROR] %s";
    static final String CHANGE_LINE = "\n";

    String createMainCommandInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COMMAND_REQUEST_MESSAGE).append(CHANGE_LINE);
        Arrays.stream(MainCommand.values()).sequential()
                .forEach(command ->
                        stringBuilder.append(String.format(COMMAND_FORM, command.getButton(), command.getViewName()))
                                .append(CHANGE_LINE));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(CHANGE_LINE));
        return stringBuilder.toString();
    }

    String createErrorMessage(Exception e) {
        return String.format(ERROR_MESSAGE_FORM, e.getMessage());
    }

}
