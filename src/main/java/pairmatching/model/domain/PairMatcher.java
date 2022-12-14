package pairmatching.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import pairmatching.model.constants.ErrorMessage;

public class PairMatcher {
    private final List<String> crewNames;
    private final List<PairGroup> sameCourseLevelPairs;

    public PairMatcher(List<String> crewNames, List<PairGroup> sameCourseLevelPairs) {
        if (crewNames.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.CREW_TO_MATCH_INSUFFICIENT);
        }
        this.crewNames = crewNames;
        this.sameCourseLevelPairs = sameCourseLevelPairs;
    }

    public PairGroup match() {
        validateMatchCases();
        int trialCount = 1;
        List<Pair> pairs = makePairs();
        while (pairs == null) {
            trialCount++;
            validateTrialCount(trialCount);
            pairs = makePairs();
        }
        return new PairGroup(pairs);
    }

    private void validateMatchCases() {
        if (isImpossibleToMatch()) {
            throw new IllegalArgumentException(ErrorMessage.PAIR_MATCH_IMPOSSIBLE);
        }
    }

    private boolean isImpossibleToMatch() {
        return crewNames.stream()
                .anyMatch(this::isCrewUnMatchable);
    }

    private boolean isCrewUnMatchable(String crewName) {
        return crewNames.stream()
                .allMatch(secondCrewName -> areMatchedCrews(crewName, secondCrewName));
    }

    private void validateTrialCount(int trialCount) {
        if (trialCount == 4) {
            throw new IllegalArgumentException(ErrorMessage.PAIR_MATCH_TRIAL_COUNT_OVER);
        }
    }

    private List<Pair> makePairs() {
        Stack<String> crewsToMatch = shuffle(crewNames);
        List<Pair> pairs = new ArrayList<>();
        while (crewsToMatch.size() > 1) {
            Pair matchedPair = matchCrew(crewsToMatch.pop(), crewsToMatch.pop());
            if (matchedPair == null) {
                return null;
            }
            pairs.add(matchedPair);
        }
        if (crewsToMatch.size() == 1) {
            Pair lastPair = pairs.get(pairs.size() - 1);
            lastPair.addCrew(crewsToMatch.pop());
        }
        return pairs;
    }

    private Stack<String> shuffle(List<String> crewNames) {
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        Collections.reverse(shuffledCrew);
        Stack<String> crewsToMatch = new Stack<>();
        crewsToMatch.addAll(shuffledCrew);
        return crewsToMatch;
    }

    private Pair matchCrew(String firstCrewName, String secondCrewName) {
        if (areMatchedCrews(firstCrewName, secondCrewName)) {
            return null;
        }
        return new Pair(List.of(firstCrewName, secondCrewName));
    }

    private boolean areMatchedCrews(String firstCrewName, String secondCrewName) {
        return sameCourseLevelPairs.stream()
                .anyMatch(pairGroup -> pairGroup.hasAlreadyMatched(firstCrewName, secondCrewName));
    }
}