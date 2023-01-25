package pairmatching.view.constants;

import java.util.regex.Pattern;

public class InputFormat {
    public static final String DELIMITER_STEP = ",";
    public static final Pattern PATTERN_STEP = Pattern.compile(
            "^((\\S+), (\\S+), (\\S+))$");
}
