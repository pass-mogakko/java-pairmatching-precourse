package pairmatching.view;

public class OutputView {
    private static final MessageFactory messageFactory = new MessageFactory();

    public static void printError(Exception e) {
        String errorMessage = messageFactory.createErrorMessage(e);

        System.out.println();
        System.out.println(errorMessage);
        System.out.println();
    }

}
