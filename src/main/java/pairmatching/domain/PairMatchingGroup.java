package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingGroup {

    private final List<PairMatching> pairMatchingGroup = new ArrayList<>();

    public void backendPairMatching(List<String> crews, String level, String mission) {
        PairMatching pairMatching = new PairMatching(Course.BACKEND, level, mission, crews);
        pairMatchingGroup.add(pairMatching);
    }

    public void frontendPairMatching(List<String> crews, String level, String mission) {
        PairMatching pairMatching = new PairMatching(Course.FRONTEND, level, mission, crews);
        pairMatchingGroup.add(pairMatching);
    }

    public List<List<String>> findBackendPairMatching(String level, String mission) {
        return pairMatchingGroup.stream()
                .filter(pairMatching -> pairMatching.isSameCourse(Course.BACKEND))
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .filter(pairMatching -> pairMatching.isSameMission(mission))
                .map(PairMatching::getCrews)
                .collect(Collectors.toList());
    }

    public List<List<String>> findFrontendPairMatching(String level, String mission) {
        return pairMatchingGroup.stream()
                .filter(pairMatching -> pairMatching.isSameCourse(Course.FRONTEND))
                .filter(pairMatching -> pairMatching.isSameLevel(level))
                .filter(pairMatching -> pairMatching.isSameMission(mission))
                .map(PairMatching::getCrews)
                .collect(Collectors.toList());
    }
}
