package pairmatching.domain.woowacourse;

import java.util.Arrays;
import java.util.Optional;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Optional<Level> convert(String name) {
        return Arrays.stream(values())
                .filter(level -> name.equals(level.name))
                .findFirst();
    }

}