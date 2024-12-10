package bridge.view.output;

import static bridge.view.output.OutputMessage.GAME_RESULT;
import static bridge.view.output.OutputMessage.INPUT_BRIDGE_SIZE;
import static bridge.view.output.OutputMessage.INPUT_SPACE_TO_MOVE;
import static bridge.view.output.OutputMessage.INPUT_TRY_AGAIN;
import static bridge.view.output.OutputMessage.START_BRIDGE_GAME;
import static bridge.view.output.OutputMessage.SUCCESS_OR_FAILURE;
import static bridge.view.output.OutputMessage.TOTAL_ATTEMPTS;

import bridge.domain.UpDownBridge;
import java.util.List;

public class OutputView {
    public static void printBridgeSize() {
        System.out.println(START_BRIDGE_GAME.getMessage());
        System.out.println();
        System.out.println(INPUT_BRIDGE_SIZE.getMessage());
    }

    public static void printSpaceToMove() {
        System.out.println(INPUT_SPACE_TO_MOVE.getMessage());
    }

    public static void printTryAgain() {
        System.out.println(INPUT_TRY_AGAIN.getMessage());
    }

    public static boolean printMap(List<String> bridges, UpDownBridge upDownBridge) {
        int userBridgeSize = upDownBridge.getUpBridge().size();
        int bridgeSize = bridges.size();

        printCurrentResult(upDownBridge);

        if (upDownBridge.getUpBridge().get(userBridgeSize - 1).equals("X")) {
            throw new IllegalArgumentException();
        }
        if (upDownBridge.getDownBridge().get(userBridgeSize - 1).equals("X")) {
            throw new IllegalArgumentException();
        }

        return userBridgeSize == bridgeSize;
    }

    public static void printResult(UpDownBridge upDownBridge, String result, Integer totalAttempts) {
        System.out.println(GAME_RESULT.getMessage());

        printCurrentResult(upDownBridge);

        System.out.printf(SUCCESS_OR_FAILURE.getMessage(), result);
        System.out.printf(TOTAL_ATTEMPTS.getMessage(), totalAttempts);
    }

    private static void printCurrentResult(UpDownBridge upDownBridge) {
        System.out.println("[ " + String.join(" | ", upDownBridge.getUpBridge()) + " ]");
        System.out.println("[ " + String.join(" | ", upDownBridge.getDownBridge()) + " ]");
    }

}
