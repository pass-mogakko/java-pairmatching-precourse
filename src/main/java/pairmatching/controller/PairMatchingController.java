package pairmatching.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.service.PairMatchingService;
import pairmatching.utils.Utils;
import pairmatching.view.FunctionSelection;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final PairMatchingService pairMatchingService = new PairMatchingService();


    public PairMatchingController() {
        selectionNavigator.put(FunctionSelection.PAIR_MATCHING.getSelection(), this::pairMatching);
        selectionNavigator.put(FunctionSelection.PAIR_LOOKUP.getSelection(), this::pairLookup);
        selectionNavigator.put(FunctionSelection.PAIR_INIT.getSelection(), this::pairInit);
        pairMatchingService.initData();
    }

    public void run() {
        String functionSelection = Utils.exceptionHandlingRepeat(InputView::requestFunctionSelection, OutputView::printErrorMessage);
        if (functionSelection.equals(FunctionSelection.QUIT.getSelection())) {
            return;
        }
        Runnable nextAction = selectionNavigator.get(functionSelection);
        Utils.exceptionHandling(nextAction, OutputView::printErrorMessage);
        run();
    }

    private void pairMatching() {
        OutputView.printAllCourseLevelMission();
        List<String> courseLevelMission = Utils.exceptionHandlingRepeat(InputView::requestCourseLevelMission, OutputView::printErrorMessage);
    }

    private void pairLookup() {
    }

    private void pairInit() {
    }
}
