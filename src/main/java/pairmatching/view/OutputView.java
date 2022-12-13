package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import pairmatching.constant.Constant;
import pairmatching.constant.Message;
import pairmatching.constant.MessageForm;
import pairmatching.domain.Course;
import pairmatching.domain.LevelAndMissions;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(MessageForm.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printAllCourseLevelMission() {
        List<String> courseAllNames = Course.findAllNames();
        String courses = String.join(Constant.JOIN_STRING, courseAllNames);
        System.out.println();
        System.out.println(Message.DIVISION_LINE);
        System.out.printf(MessageForm.COURSE_FROM, courses);
        System.out.println();
        System.out.println(Message.MISSION);
        Arrays.stream(LevelAndMissions.values())
                .map(LevelAndMissions::toKorean)
                .forEach(System.out::println);
        System.out.println(Message.DIVISION_LINE);
    }

    public static void printPairMatchingResult(List<List<String>> pairMatchingCrewNames) {
        System.out.println(Message.PAIR_MATCHING_RESULT);
        pairMatchingCrewNames.forEach(OutputView::printPairMatching);
    }

    private static void printPairMatching(List<String> pairMatchingCrewNames) {
        String pairMatching = String.join(Message.PAIR_MATCHING_JOIN_REGEX, pairMatchingCrewNames);
        System.out.println(pairMatching);
    }

    public static void printPairInit() {
        System.out.println(Message.PAIR_INIT);
    }
}
