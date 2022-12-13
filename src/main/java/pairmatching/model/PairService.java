package pairmatching.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import pairmatching.model.constants.ErrorMessage;
import pairmatching.model.domain.Crew;

public class PairService {
    public void match(List<Crew> crews) {
        if (crews.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.CREW_TO_MATCH_INSUFFICIENT);
        }
        Queue<Crew> shuffledCrew = shuffle(crews);
        System.out.println(shuffledCrew);
    }

    private Queue<Crew> shuffle(List<Crew> crews) {
        Collections.shuffle(crews);
        return new LinkedList<>(crews);
    }
}
