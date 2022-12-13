package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.MainCommand;

public class InputView {
    private static final MessageFactory messageFactory = new MessageFactory();

    public static MainCommand readMainCommand() {
        String commandInfo = messageFactory.createMainCommandInfo();
        System.out.println(commandInfo);

        String input = Console.readLine();
        InputValidator.validateMainCommand(input);
        return MainCommand.getCommand(input);
    }
}
