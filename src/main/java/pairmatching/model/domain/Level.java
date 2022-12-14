package pairmatching.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import pairmatching.model.constants.ErrorMessage;

public enum Level {
    LEVEL1("레벨1", new ArrayList<>(List.of("자동차경주", "로또", "숫자야구게임"))),
    LEVEL2("레벨2", new ArrayList<>(List.of("장바구니", "결제", "지하철노선도"))),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", new ArrayList<>(List.of("성능개선", "배포"))),
    LEVEL5("레벨5", new ArrayList<>());

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level findByName(String name) {
        return Arrays.stream(values())
                .filter(level -> Objects.equals(level.name, name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.LEVEL_NOT_FOUND));
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }

    public boolean hasMission(String mission) {
        return missions.contains(mission);
    }
}
