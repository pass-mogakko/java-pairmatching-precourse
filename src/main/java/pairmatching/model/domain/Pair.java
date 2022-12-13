package pairmatching.model.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> matchedCrews;

    public Pair(List<Crew> matchedCrews) {
        this.matchedCrews = matchedCrews;
    }

    public boolean containsCrews(Crew crew1, Crew crew2) {
        return matchedCrews.contains(crew1) && matchedCrews.contains(crew2);
    }

    public List<Crew> getMatchedCrews() {
        return Collections.unmodifiableList(matchedCrews);
    }

    public List<String> getAllCrewNames() {
        return matchedCrews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public void addCrew(Crew crew) {
        matchedCrews.add(crew);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "matchedCrews=" + matchedCrews +
                '}';
    }
}
