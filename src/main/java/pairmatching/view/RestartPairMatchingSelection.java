package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.ErrorMessage;

public enum RestartPairMatchingSelection {
    YES("네"),
    NO("아니오");

    private final String selection;

    RestartPairMatchingSelection(String selection) {
        this.selection = selection;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(RestartPairMatchingSelection.values())
                .anyMatch(restartPairMatchingSelection -> restartPairMatchingSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public static List<String> findAllSelection() {
        return Arrays.stream(RestartPairMatchingSelection.values())
                .map(RestartPairMatchingSelection::getSelection)
                .collect(Collectors.toList());
    }

    public String getSelection() {
        return selection;
    }

}
