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
}
