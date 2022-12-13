package pairmatching.view.constants;

import java.util.regex.Pattern;

public class InputFormat {
    public static final String DELIMITER_STEP = ",";
    public static final Pattern PATTERN_STEP = Pattern.compile(
            "^(([ㄱ-ㅎ|가-힣a-zA-Z0-9]+), ([ㄱ-ㅎ|가-힣a-zA-Z0-9]+), ([ㄱ-ㅎ|가-힣a-zA-Z0-9]+))$");
}
