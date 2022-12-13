package pairmatching.model;

import java.util.List;
import pairmatching.model.constants.ErrorMessage;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.PairGroup;
import pairmatching.model.domain.PairGroupRepository;
import pairmatching.model.domain.PairMatcher;
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
        PairMatcher pairMatcher = new PairMatcher(step, crews);
        PairGroup pairGroup = PairGroupRepository.findByCourseLevel(step.getCourse(), step.getLevel());
    }

    public void reset() {
        PairGroupRepository.deleteAll();
    }
}
