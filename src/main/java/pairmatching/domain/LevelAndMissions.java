package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Constant;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.MessageForm;

public enum LevelAndMissions {

    LEVEL1("레벨1", "자동차경주 | 로또 | 숫자야구게임"),
    LEVEL2("레벨2", "장바구니 | 결제  | 지하철노선도"),
    LEVEL3("레벨3", Constant.EMPTY),
    LEVEL4("레벨4", "성능개선 | 배포"),
    LEVEL5("레벨5", Constant.EMPTY);

    private String level;
    private String missions;

    LevelAndMissions(String level, String missions) {
        this.level = level;
        this.missions = missions;
    }

    public static List<String> findAllLevels() {
        return Arrays.stream(LevelAndMissions.values())
                .map(LevelAndMissions::getLevel)
                .collect(Collectors.toList());
    }

    public static LevelAndMissions findByLevel(String level) {
        return Arrays.stream(LevelAndMissions.values())
                .filter(levelAndMissions -> levelAndMissions.level.equals(level))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LEVEL));
    }

    public void validateMission(String mission) {
        List<String> allMissions = findAllMissions();
        if (!allMissions.contains(mission)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_MISSION);
        }
    }

    public List<String> findAllMissions() {
        return Arrays.stream(missions.split(Constant.MISSION_SPLIT_REGEX))
                .collect(Collectors.toList());

    }

    public boolean isEmptyMission() {
        return missions.equals(Constant.EMPTY);
    }

    public String toKorean() {
        return String.format(MessageForm.LEVEL_MESSAGE_FORM, level, missions);
    }


    public String getLevel() {
        return level;
    }
}