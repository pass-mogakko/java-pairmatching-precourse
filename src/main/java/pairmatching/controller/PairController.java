package pairmatching.controller;

import java.util.List;
import pairmatching.controller.dto.PairDTO;
import pairmatching.controller.dto.StepDTO;
import pairmatching.model.CrewService;
import pairmatching.model.OptionService;
import pairmatching.model.PairService;
import pairmatching.view.ActionCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final OptionService optionService = new OptionService();
    private final CrewService crewService = new CrewService();
    private final PairService pairService = new PairService();

    public void match() {
        OutputView.printOption(optionService.getAllOptions());
        StepDTO stepDTO = InputView.readStep();
        if (pairService.hasMatched(stepDTO) && !toRematch()) {
            return;
        }
        List<String> crewNames = crewService.findAllCrewNamesByCourse(stepDTO.getCourse());
        pairService.match(stepDTO, crewNames);
        List<PairDTO> pairResult = pairService.readPairGroup(stepDTO);
        OutputView.printPairResult(pairResult);
    }

    private boolean toRematch() {
        ActionCommand toRematch = InputView.readActionCommand();
        return toRematch == ActionCommand.YES;
    }

    public void read() {
        OutputView.printOption(optionService.getAllOptions());
        StepDTO stepDTO = InputView.readStep();
        List<PairDTO> pairResult = pairService.readPairGroup(stepDTO);
        OutputView.printPairResult(pairResult);
    }

    public void reset() {
        pairService.reset();
    }
}
