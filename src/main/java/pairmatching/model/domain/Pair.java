package pairmatching.model.domain;

import java.util.List;

public class Pair {
    private final List<Crew> matchedCrews;

    public Pair(List<Crew> matchedCrews) {
        this.matchedCrews = matchedCrews;
    }

    public boolean containsCrews(Crew crew1, Crew crew2) {
        return matchedCrews.contains(crew1) && matchedCrews.contains(crew2);
    }
}
