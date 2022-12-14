package pairmatching.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import pairmatching.model.constants.ErrorMessage;

public class PairMatcher {
    private final List<Crew> crews;
    private final List<PairGroup> sameCourseLevelPairs;

    public PairMatcher(List<Crew> crews, List<PairGroup> sameCourseLevelPairs) {
        if (crews.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.CREW_TO_MATCH_INSUFFICIENT);
        }
        this.crews = crews;
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
        return crews.stream()
                .anyMatch(this::isCrewUnMatchable);
    }

    private boolean isCrewUnMatchable(Crew crew) {
        return crews.stream()
                .allMatch(secondCrew -> areMatchedCrews(crew, secondCrew));
    }

    private void validateTrialCount(int trialCount) {
        if (trialCount == 4) {
            throw new IllegalArgumentException(ErrorMessage.PAIR_MATCH_TRIAL_COUNT_OVER);
        }
    }

    private List<Pair> makePairs() {
        Stack<Crew> crewsToMatch = shuffle(crews);
        List<Pair> pairs = new ArrayList<>();
        while (crewsToMatch.size() > 2) {
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

    private Stack<Crew> shuffle(List<Crew> crews) {
        List<Crew> shuffledCrew = Randoms.shuffle(crews);
        Collections.reverse(shuffledCrew);
        Stack<Crew> crewsToMatch = new Stack<>();
        crewsToMatch.addAll(shuffledCrew);
        return crewsToMatch;
    }

    private Pair matchCrew(Crew firstCrew, Crew secondCrew) {
        if (areMatchedCrews(firstCrew, secondCrew)) {
            return null;
        }
        return new Pair(List.of(firstCrew, secondCrew));
    }

    private boolean areMatchedCrews(Crew crew1, Crew crew2) {
        return sameCourseLevelPairs.stream()
                .anyMatch(pairGroup -> pairGroup.hasAlreadyMatched(crew1, crew2));
    }
}