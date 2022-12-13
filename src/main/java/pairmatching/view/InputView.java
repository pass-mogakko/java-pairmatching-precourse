package pairmatching.view;

import static pairmatching.constant.ErrorMessage.WRONG_COURSE_LEVEL_MISSION_FORM;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Constant;
import pairmatching.constant.Message;
import pairmatching.domain.Course;
import pairmatching.domain.LevelAndMissions;

public class InputView {

    public static String requestFunctionSelection() {
        System.out.println();
        System.out.println(Message.REQUEST_FUNCTION_SELECTION);
        Arrays.stream(FunctionSelection.values())
                .map(FunctionSelection::toKorean)
                .forEach(System.out::println);
        String functionSelection = Console.readLine();
        FunctionSelection.validate(functionSelection);
        return functionSelection;
    }

    public static List<String> requestCourseLevelMission() {
        System.out.println();
        System.out.println(Message.REQUEST_COURSE_LEVEL_MISSION);
        System.out.println(Message.COURSE_LEVEL_MISSION_EXAMPLE);
        String courseLevelMission = Console.readLine();
        List<String> parsedCourseLevelMission = Arrays.stream(courseLevelMission.split(Constant.COURSE_LEVEL_MISSION_SPLIT_REGEX))
                .collect(Collectors.toList());
        validateCourseLevelMission(parsedCourseLevelMission);
        return parsedCourseLevelMission;
    }

    private static void validateCourseLevelMission(List<String> courseLevelMission) {
        if (courseLevelMission.size() != Constant.COURSE_LEVEL_MISSION_INPUT_SIZE) {
            throw new IllegalArgumentException(WRONG_COURSE_LEVEL_MISSION_FORM);
        }
        boolean hasEmptyString = courseLevelMission.stream()
                .anyMatch(string -> string.equals(Constant.EMPTY));
        if (hasEmptyString) {
            throw new IllegalArgumentException(WRONG_COURSE_LEVEL_MISSION_FORM);
        }
        String course = courseLevelMission.get(Constant.COURSE_INDEX);
        String level = courseLevelMission.get(Constant.LEVEL_INDEX);
        String mission = courseLevelMission.get(Constant.MISSION_INDEX);
        Course.validate(course);
        LevelAndMissions levelAndMissions = LevelAndMissions.findByLevel(level);
        levelAndMissions.validateMission(mission);
    }

    public static boolean requestRestartPairMatching() {
        System.out.println(Message.REQUEST_RESTART_PAIR_MATCHING);
        List<String> allSelection = RestartPairMatchingSelection.findAllSelection();
        String selections = String.join(Constant.JOIN_STRING, allSelection);
        System.out.println(selections);
        String input = Console.readLine();
        RestartPairMatchingSelection.validate(input);
        return input.equals(RestartPairMatchingSelection.YES.getSelection());
    }
}
