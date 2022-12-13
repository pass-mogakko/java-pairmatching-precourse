package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

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
}
