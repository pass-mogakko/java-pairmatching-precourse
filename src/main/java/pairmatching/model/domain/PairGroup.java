package pairmatching.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairGroup {
    private final List<Pair> pairs;

    public PairGroup(List<Pair> pairs) {
        this.pairs = new ArrayList<>(pairs);
    }

    public boolean hasAlreadyMatched(String firstCrew, String secondCrew) {
        return pairs.stream()
                .anyMatch(pair -> pair.containsCrews(firstCrew, secondCrew));
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}
