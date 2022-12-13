package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public static List<String> findAllNames() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    public static void validate(String name) {
        boolean isAnyMatch = Arrays.stream(Course.values())
                .anyMatch(course -> course.name.equals(name));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_COURSE);
        }
    }

    public String getName() {
        return name;
    }
}