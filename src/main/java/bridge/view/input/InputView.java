package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String input() {
        return Console.readLine();
    }

    public static int inputBridgeSize() {
        String bridgeSize = input();
        InputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public static String inputSpaceToMove() {
        String spaceToMove = input();
        InputValidator.validateSpaceToMove(spaceToMove);
        return spaceToMove;
    }

    public static String inputTryAgain() {
        String tryAgain = input();
        InputValidator.validateTryAgain(tryAgain);
        return tryAgain;
    }
}

