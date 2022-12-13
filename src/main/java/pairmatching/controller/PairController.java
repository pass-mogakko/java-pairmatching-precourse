package pairmatching.controller;

import java.util.List;
import pairmatching.controller.dto.StepDTO;
import pairmatching.model.CrewService;
import pairmatching.model.PairService;
import pairmatching.model.domain.Crew;
import pairmatching.model.domain.PairGroup;
import pairmatching.model.domain.Step;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final CrewService crewService = new CrewService();
    private final PairService pairService = new PairService();

    public void match() {
        OutputView.printPairMatchScreen();
        StepDTO stepDTO = InputView.readStep();
        Step step = new Step(stepDTO.getCourse(), stepDTO.getLevel(), stepDTO.getMission());
        if (pairService.hasMatched(step)) {
            // TODO 재매치 여부 입력
        }
        List<Crew> crews = crewService.findAllCrewsByCourse(stepDTO.getCourse());
        pairService.match(step, crews);
    }

    public void read() {
        OutputView.printPairMatchScreen();
        StepDTO stepDTO = InputView.readStep();
        PairGroup pairGroup = pairService.readPairGroup(
                new Step(stepDTO.getCourse(), stepDTO.getLevel(), stepDTO.getMission()));
        System.out.println(pairGroup);
    }

    public void reset() {
        System.out.println("RESET");
    }
}
