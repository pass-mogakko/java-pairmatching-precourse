package pairmatching.model.domain;

import java.util.List;

public class Pair {
    private final List<Crew> matchedCrews;

    public Pair(List<Crew> matchedCrews) {
        this.matchedCrews = matchedCrews;
    }
}
