package pairmatching.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import pairmatching.model.constants.ErrorMessage;

public class PairMatcher {
    private final Step step;
    private final Queue<Crew> crewsToMatch;
    private final List<PairGroup> sameCourseLevelPairs;

    public PairMatcher(Step step, List<Crew> crews) {
        if (crews.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.CREW_TO_MATCH_INSUFFICIENT);
        }
        this.step = step;
        this.crewsToMatch = shuffle(crews);
        this.sameCourseLevelPairs = PairGroupRepository.findByCourseLevel(step.getCourse(), step.getLevel());
    }

    public PairGroup match() {
        List<Pair> pairs = new ArrayList<>();
        while (crewsToMatch.size() > 2) {
            Pair pair = new Pair(new ArrayList<>(matchCrew()));
            pairs.add(pair);
        }
        if (crewsToMatch.size() == 1) {
            addLastSingleCrew(pairs);
        }
        return new PairGroup(step, pairs);
    }

    private Queue<Crew> shuffle(List<Crew> crews) {
        Collections.shuffle(crews);
        return new LinkedList<>(crews);
    }

    private List<Crew> matchCrew() {
        Crew crew1 = crewsToMatch.poll();
        Crew crew2 = crewsToMatch.peek();
        if (areMatchedCrews(crew1, crew2)) {
            crewsToMatch.add(crew1);
        }
        crew2 = crewsToMatch.poll();
        return List.of(crew1, crew2);
    }

    private boolean areMatchedCrews(Crew crew1, Crew crew2) {
        return sameCourseLevelPairs.stream()
                .anyMatch(pairGroup -> pairGroup.hasAlreadyMatched(crew1, crew2));
    }

    private void addLastSingleCrew(List<Pair> pairs) {
        int lastIndex = pairs.size() - 1;
        Pair lastPair = pairs.get(lastIndex);
        List<Crew> newLastPair = new ArrayList<>(lastPair.getMatchedCrews());
        newLastPair.add(crewsToMatch.poll());
        pairs.add(lastIndex, new Pair(new ArrayList<>(newLastPair)));
    }
}
