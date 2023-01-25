package pairmatching.model.domain;

import java.util.Arrays;
import java.util.Objects;
import pairmatching.model.constants.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByName(String name) {
        return Arrays.stream(values())
                .filter(course -> Objects.equals(course.name, name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COURSE_NOT_FOUND));
    }

    public String getName() {
        return name;
    }
}
