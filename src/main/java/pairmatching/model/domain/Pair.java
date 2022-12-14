package pairmatching.model.domain;

import java.util.Collections;
import java.util.List;

public class Pair {
    private final List<String> matchedCrewNames;

    public Pair(List<String> matchedCrewNames) {
        this.matchedCrewNames = matchedCrewNames;
    }

    public boolean containsCrews(String firstCrewName, String secondCrewName) {
        return matchedCrewNames.contains(firstCrewName) && matchedCrewNames.contains(secondCrewName);
    }

    public List<String> getMatchedCrewNames() {
        return Collections.unmodifiableList(matchedCrewNames);
    }

    public void addCrew(String crewName) {
        matchedCrewNames.add(crewName);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "matchedCrews=" + matchedCrewNames +
                '}';
    }
}
