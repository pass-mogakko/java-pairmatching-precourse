package pairmatching.domain.woowacourse;

import java.util.Arrays;
import java.util.Optional;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    ENHANCEMENT("성능개선"),
    RELEASE("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    public static Optional<Mission> convert(String name) {
        return Arrays.stream(values())
                .filter(mission -> name.equals(mission.name))
                .findFirst();
    }

}
