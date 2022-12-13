package pairmatching.view;

import pairmatching.domain.woowacourse.Course;
import pairmatching.domain.woowacourse.Level;
import pairmatching.domain.command.MainCommand;
import pairmatching.domain.woowacourse.Mission;

import java.util.List;

import static pairmatching.util.ErrorMessage.*;

public class InputValidator {
    private static final String SEPARATING_REGEX = ", ";

    static void validateMainCommand(String button) {
        if (MainCommand.convert(button) == null) {
            throw new IllegalArgumentException(COMMAND_NOT_FOUND);
        }
    }

    static List<Object> validateOptions(String input) {
        List<String> inputs = List.of(input.split(SEPARATING_REGEX));
        try {
            Course course = convertToCourse(inputs.get(0));
            Level level = convertToLevel(inputs.get(1));
            Mission mission = convertToMission(inputs.get(2));
            return List.of(course, level, mission);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORM);
        }
    }

    private static Course convertToCourse(String name) {
        return Course.convert(name)
                .orElseThrow(() -> new IllegalArgumentException(COURSE_NOT_FOUND));
    }

    private static Mission convertToMission(String name) {
        return Mission.convert(name)
                .orElseThrow(() -> new IllegalArgumentException(MISSION_NOT_FOUND));
    }

    private static Level convertToLevel(String name) {
        return Level.convert(name)
                .orElseThrow(() -> new IllegalArgumentException(LEVEL_NOT_FOUND));
    }

}
