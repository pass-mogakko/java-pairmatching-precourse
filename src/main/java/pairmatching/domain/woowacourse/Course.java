package pairmatching.domain.woowacourse;

import java.util.Arrays;
import java.util.Optional;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Optional<Course> convert(String name) {
        return Arrays.stream(values())
                .filter(mainCommand -> name.equals(mainCommand.name))
                .findFirst();
    }

}