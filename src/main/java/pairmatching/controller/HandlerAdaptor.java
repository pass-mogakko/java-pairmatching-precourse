package pairmatching.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import pairmatching.view.menu.MenuCommand;

public enum HandlerAdaptor {
    MATCH(MenuCommand.MATCH, PairController::match),
    READ(MenuCommand.READ, PairController::read),
    RESET(MenuCommand.RESET, PairController::reset);

    private static final Map<MenuCommand, Consumer<PairController>> functionByCommand = Arrays.stream(values())
            .collect(Collectors.toMap(value -> value.menuCommand, value -> value.function));
    private final MenuCommand menuCommand;
    private final Consumer<PairController> function;

    HandlerAdaptor(MenuCommand menuCommand, Consumer<PairController> function) {
        this.menuCommand = menuCommand;
        this.function = function;
    }

    public static void executeFunctionByCommand(PairController controller, MenuCommand command) {
        Consumer<PairController> selectedFunction = functionByCommand.get(command);
        if (selectedFunction == null) {
            throw new IllegalArgumentException("해당 입력 키워드로 실행할 수 있는 기능이 없습니다.");
        }
        selectedFunction.accept(controller);
    }
}
