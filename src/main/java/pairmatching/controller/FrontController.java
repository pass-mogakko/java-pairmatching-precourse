package pairmatching.controller;

import pairmatching.controller.util.ExceptionHandler;
import pairmatching.model.CrewService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.menu.MenuCommand;

public class FrontController {
    private final CrewService crewService = new CrewService();
    private final PairController pairController = new PairController();

    public void execute() {
        ExceptionHandler.retryForIllegalArgument(this::executeFunction, OutputView::printErrorMessage);
    }

    private void executeFunction() {
        MenuCommand menuCommand = ExceptionHandler.retryForIllegalArgument(InputView::inputMenuCommand,
                OutputView::printErrorMessage);
        if (menuCommand == MenuCommand.QUIT) {
            return;
        }
        HandlerAdaptor.executeFunctionByCommand(pairController, menuCommand);
    }
}
