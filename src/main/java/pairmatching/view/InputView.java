package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import pairmatching.constant.Message;

public class InputView {

    public static String requestFunctionSelection() {
        System.out.println(Message.REQUEST_FUNCTION_SELECTION);
        Arrays.stream(FunctionSelection.values())
                .map(FunctionSelection::toKorean)
                .forEach(System.out::println);
        String functionSelection = Console.readLine();
        FunctionSelection.validate(functionSelection);
        return functionSelection;
    }
}
