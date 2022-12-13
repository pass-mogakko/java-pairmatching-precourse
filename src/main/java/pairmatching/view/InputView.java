package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.command.MainCommand;

import java.util.List;

public class InputView {
    private static final MessageFactory messageFactory = new MessageFactory();

    public static MainCommand readMainCommand() {
        String commandInfo = messageFactory.createMainCommandInfo();
        System.out.println(commandInfo);

        String input = Console.readLine();
        InputValidator.validateMainCommand(input);
        return MainCommand.convert(input);
    }

    public static List<Object> readOptions() {
        String commandInfo = messageFactory.createOptionRequestMessage();
        System.out.println(commandInfo);

        String input = Console.readLine();
        List<Object> inputs = InputValidator.validateOptions(input);
        return inputs;
    }
}
