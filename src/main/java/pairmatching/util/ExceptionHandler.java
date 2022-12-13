package pairmatching.util;

import pairmatching.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T handleInputException(Supplier<T> readInput) {
        try {
            return readInput.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return handleInputException(readInput);
        }
    }

}