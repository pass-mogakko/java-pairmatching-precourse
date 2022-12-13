package pairmatching.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import pairmatching.model.constants.ErrorMessage;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.PairGroup;
import pairmatching.model.domain.PairGroupRepository;
import pairmatching.model.domain.Step;

public class PairService {
    public boolean hasMatched(Step step) {
        return PairGroupRepository.findByStep(step) != null;
    }

    public PairGroup readPairGroup(Step step) {
        PairGroup pairGroup = PairGroupRepository.findByStep(step);
        if (pairGroup == null) {
            throw new IllegalArgumentException(ErrorMessage.PAIR_GROUP_NOT_FOUND);
        }
        return pairGroup;
    }

    public void match(Step step, List<Crew> crews) {
        if (crews.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.CREW_TO_MATCH_INSUFFICIENT);
        }
        Queue<Crew> shuffledCrew = shuffle(crews);
//        System.out.println(shuffledCrew);
    }

    private Queue<Crew> shuffle(List<Crew> crews) {
        Collections.shuffle(crews);
        return new LinkedList<>(crews);
    }

    public void reset() {
        PairGroupRepository.deleteAll();
    }
}
