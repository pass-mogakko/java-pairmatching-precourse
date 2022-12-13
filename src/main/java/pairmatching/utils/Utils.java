package pairmatching.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Utils {

    public static <T> T exceptionHandlingRepeat(Supplier<T> supplier, Consumer<String> printErrorFunction) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            return exceptionHandlingRepeat(supplier, printErrorFunction);
        }
    }

    public static void exceptionHandling(Runnable runnable, Consumer<String> printErrorFunction) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
        }
    }
}
