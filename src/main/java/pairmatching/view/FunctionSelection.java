package pairmatching.view;

import java.util.Arrays;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.MessageForm;

public enum FunctionSelection {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_LOOKUP("2", "페어 조회"),
    PAIR_INIT("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String selection;
    private final String content;

    FunctionSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(FunctionSelection.values())
                .anyMatch(mainScreenSelection -> mainScreenSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public String toKorean() {
        return String.format(MessageForm.SELECTION_MESSAGE_FORM, selection, content);
    }

    public String getSelection() {
        return selection;
    }
}
