package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;
import pairmatching.controller.dto.StepDTO;
import pairmatching.view.constants.ErrorMessage;
import pairmatching.view.constants.InputFormat;
import pairmatching.view.constants.InputMessage;
import pairmatching.view.constants.OutputFormat;
import pairmatching.view.menu.Menu;
import pairmatching.view.menu.MenuCommand;

public class InputView {
    public static MenuCommand inputMenuCommand() {
        System.out.println(InputMessage.SELECT_MENU);
        showMenus();
        MenuCommand menuCommand = readMenuCommand();
        System.out.println();
        return menuCommand;
    }

    private static void showMenus() {
        Arrays.stream(Menu.values())
                .forEach(menu -> System.out.printf(OutputFormat.MENU_SCREEN, menu.getCommand().getKey(),
                        menu.getName()));
    }

    private static MenuCommand readMenuCommand() {
        String line = Console.readLine();
        return MenuCommand.find(line);
    }

    public static StepDTO readStep() {
        System.out.println(InputMessage.SELECT_STEP);
        String line = Console.readLine();
        System.out.println();
        validateStepFormat(line, InputFormat.PATTERN_STEP);
        String[] values = line.split(InputFormat.DELIMITER_STEP);
        return new StepDTO(values[0].trim(), values[1].trim(), values[2].trim());
    }

    private static void validateStepFormat(String line, Pattern pattern) {
        if (!pattern.matcher(line).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_STEP_FORMAT);
        }
    }
}
