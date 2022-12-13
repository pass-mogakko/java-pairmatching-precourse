package pairmatching.view;

import pairmatching.domain.MainCommand;

import java.util.Arrays;

public class MessageFactory {
    // 명령어 관련 상수
    static final String COMMAND_REQUEST_MESSAGE = "기능을 선택하세요.";
    static final String COMMAND_FORM = "%s. %s";

    // 레벨, 미션 관련 상수 (일단 하드코딩) - 시간 나면 리팩토링
    static final String COURSE_INFO = "과정: 백엔드 | 프론트엔드\n";
    static final String MISSION_INFO = "미션:\n" + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" + "  - 레벨3: \n" + "  - 레벨4: 성능개선 | 배포\n" + "  - 레벨5: \n";

    // 기타
    static final String CONTENT_SEPARATOR = "#############################################\n";
    static final String ERROR_MESSAGE_FORM = "[ERROR] %s";
    static final String CHANGE_LINE = "\n";

    String createMainCommandInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COMMAND_REQUEST_MESSAGE).append(CHANGE_LINE);
        Arrays.stream(MainCommand.values()).sequential()
                .forEach(command ->
                        stringBuilder.append(String.format(COMMAND_FORM, command.getButton(), command.getViewName()))
                                .append(CHANGE_LINE));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(CHANGE_LINE));
        return stringBuilder.toString();
    }

    String createErrorMessage(Exception e) {
        return String.format(ERROR_MESSAGE_FORM, e.getMessage());
    }

    String createLevelAndMissionInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CHANGE_LINE)
                .append(CONTENT_SEPARATOR)
                .append(COURSE_INFO)
                .append(MISSION_INFO)
                .append(CONTENT_SEPARATOR);
        return stringBuilder.toString();
    }
}
