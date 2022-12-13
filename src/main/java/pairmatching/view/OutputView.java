package pairmatching.view;

import pairmatching.view.constants.MessageFormat;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.printf(MessageFormat.ERROR, message);
        System.out.println(0);
    }
}
