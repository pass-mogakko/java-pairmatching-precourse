package pairmatching.view;

import pairmatching.view.constants.OutputFormat;
import pairmatching.view.constants.OutputMessage;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.printf(OutputFormat.ERROR, message);
        System.out.println();
    }

    public static void printPairMatchScreen() {
        System.out.println(OutputMessage.PAIR_MATCHING_SCREEN);
    }
}
