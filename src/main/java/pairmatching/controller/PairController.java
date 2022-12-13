package pairmatching.controller;

import java.util.List;
import pairmatching.controller.dto.StepDTO;
import pairmatching.model.CrewService;
import pairmatching.model.PairService;
import pairmatching.model.domain.Crew;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final CrewService crewService = new CrewService();
    private final PairService pairService = new PairService();

    public void match() {
        OutputView.printPairMatchScreen();
        StepDTO stepDTO = InputView.readStepToMatch();
        List<Crew> crews = crewService.findAllCrewsByCourse(stepDTO.getCourse());
        pairService.match(crews);
    }

    public void read() {
        System.out.println("READ");
    }

    public void reset() {
        System.out.println("RESET");
    }
}
