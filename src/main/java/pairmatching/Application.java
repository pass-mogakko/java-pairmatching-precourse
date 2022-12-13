package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.domain.CrewReader;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.run();
    }
}
