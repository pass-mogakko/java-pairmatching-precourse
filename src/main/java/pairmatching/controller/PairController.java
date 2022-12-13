package pairmatching.controller;

import pairmatching.view.OutputView;

public class PairController {
    public void match() {
        OutputView.printPairMatchScreen();
    }

    public void read() {
        System.out.println("READ");
    }

    public void reset() {
        System.out.println("RESET");
    }
}
