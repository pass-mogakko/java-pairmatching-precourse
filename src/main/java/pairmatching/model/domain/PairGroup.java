package pairmatching.model.domain;

import java.util.List;
import java.util.Objects;

public class PairGroup {
    private final Step step;
    private final List<Pair> pairs;

    public PairGroup(Step step, List<Pair> pairs) {
        this.step = step;
        this.pairs = pairs;
    }

    public boolean hasSameStep(Step otherStep) {
        return Objects.equals(step, otherStep);
    }

    public boolean hasSameCourseLevel(Course course, Level level) {
        return step.isSameCourseLevel(course, level);
    }

    public boolean hasAlreadyMatched(Crew crew1, Crew crew2) {
        return pairs.stream()
                .anyMatch(pair -> pair.containsCrews(crew1, crew2));
    }
}
