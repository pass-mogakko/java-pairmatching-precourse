package pairmatching.controller;

import pairmatching.controller.dto.StepDTO;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
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
