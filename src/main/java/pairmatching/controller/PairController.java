package pairmatching.controller;

import pairmatching.controller.dto.StepDTO;
import pairmatching.model.CrewService;
import pairmatching.model.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final CrewService crewService = new CrewService();
    private final PairService pairService = new PairService();
    
    public void match() {
        OutputView.printPairMatchScreen();
        StepDTO stepDTO = InputView.readStepToMatch();
    }

    public void read() {
        System.out.println("READ");
    }

    public void reset() {
        System.out.println("RESET");
    }
}
