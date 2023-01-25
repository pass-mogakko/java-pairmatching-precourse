package pairmatching.view;

import java.util.List;
import java.util.StringJoiner;
import pairmatching.controller.dto.LevelDTO;
import pairmatching.controller.dto.OptionDTO;
import pairmatching.controller.dto.PairDTO;
import pairmatching.view.constants.OutputFormat;
import pairmatching.view.constants.OutputMessage;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.printf(OutputFormat.ERROR, message);
        System.out.println();
    }

    public static void printOption(OptionDTO optionDTO) {
        System.out.println(OutputMessage.OPTION_SEPARATOR);
        System.out.printf(OutputFormat.OPTION_COURSES, joinByDelimiter(optionDTO.getCourses()
        ));
        System.out.print(OutputFormat.OPTION_MISSION);
        List<LevelDTO> levels = optionDTO.getLevels();
        levels.forEach(level -> System.out.printf(OutputFormat.OPTION_MISSIONS_BY_LEVEL,
                level.getName(), joinByDelimiter(level.getMissions())));
        System.out.println(OutputMessage.OPTION_SEPARATOR);
    }

    private static String joinByDelimiter(List<String> values) {
        StringJoiner joiner = new StringJoiner(OutputFormat.OPTION_DELIMITER);
        values.forEach(joiner::add);
        return joiner.toString();
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
