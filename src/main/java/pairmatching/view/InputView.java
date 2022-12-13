package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import pairmatching.view.constants.InputMessage;
import pairmatching.view.constants.MessageFormat;
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
                .forEach(menu -> System.out.printf(MessageFormat.MENU_SCREEN, menu.getCommand().getKey(),
                        menu.getName()));
    }

    private static MenuCommand readMenuCommand() {
        String line = Console.readLine();
        return MenuCommand.find(line);
    }
}
