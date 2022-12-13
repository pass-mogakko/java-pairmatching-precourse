package pairmatching.view;

import java.util.List;
import java.util.StringJoiner;
import pairmatching.controller.dto.PairDTO;
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

    public static void printPairResult(List<PairDTO> pairResult) {
        System.out.println(OutputMessage.PAIR_RESULT);
        pairResult.forEach(OutputView::printPair);
        System.out.println();
    }

    private static void printPair(PairDTO pairDTO) {
        StringJoiner crewNameJoiner = new StringJoiner(OutputFormat.PAIR_DELIMITER);
        pairDTO.getCrewNames()
                .forEach(crewNameJoiner::add);
        System.out.println(crewNameJoiner);
    }
}
