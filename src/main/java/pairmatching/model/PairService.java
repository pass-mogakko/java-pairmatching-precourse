package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.controller.dto.PairDTO;
import pairmatching.controller.dto.StepDTO;
import pairmatching.model.constants.ErrorMessage;
import pairmatching.model.domain.PairGroup;
import pairmatching.model.domain.PairGroupRepository;
import pairmatching.model.domain.PairMatcher;
import pairmatching.model.domain.Step;

public class PairService {
    public boolean hasMatched(StepDTO stepDTO) {
        return PairGroupRepository.findByStep(Step.toStep(stepDTO)) != null;
    }

    public List<PairDTO> readPairGroup(StepDTO stepDTO) {
        PairGroup pairGroup = PairGroupRepository.findByStep(Step.toStep(stepDTO));
        if (pairGroup == null) {
            throw new IllegalArgumentException(ErrorMessage.PAIR_GROUP_NOT_FOUND);
        }
        return pairGroup.getPairs()
                .stream()
                .map(pair -> new PairDTO(pair.getMatchedCrewNames()))
                .collect(Collectors.toList());
    }

    public void match(StepDTO stepDTO, List<String> crewNames) {
        Step step = Step.toStep(stepDTO);
        List<PairGroup> sameCourseLevelPairs = PairGroupRepository.findByCourseLevel(step.getCourse(), step.getLevel());
        PairMatcher pairMatcher = new PairMatcher(crewNames, sameCourseLevelPairs);
        PairGroup pairGroup = pairMatcher.match();
        PairGroupRepository.add(step, pairGroup);
    }

    public void reset() {
        PairGroupRepository.deleteAll();
    }
}
