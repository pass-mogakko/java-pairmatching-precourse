package pairmatching.controller;

import pairmatching.service.PairMatchingService;

public class PairMatchingController {

    private final PairMatchingService pairMatchingService = new PairMatchingService();

    public void run() {
        initData();
    }

    private void initData() {
        pairMatchingService.initData();
    }
}
