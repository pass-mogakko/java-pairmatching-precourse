package pairmatching.model.domain;

import java.util.Collections;
import java.util.List;

public class PairGroup {
    private final List<Pair> pairs;

    public PairGroup(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public boolean hasAlreadyMatched(Crew crew1, Crew crew2) {
        return pairs.stream()
                .anyMatch(pair -> pair.containsCrews(crew1, crew2));
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}
