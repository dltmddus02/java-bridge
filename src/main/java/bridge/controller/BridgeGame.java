package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.GameResult;
import bridge.domain.UpDownBridge;
import bridge.service.BridgeMaker;
import bridge.view.input.InputView;
import bridge.view.input.exception.InputException;
import bridge.view.output.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker;
    private List<String> bridges;
    private UpDownBridge upDownBridge;
    private final GameResult gameResult;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        gameResult = new GameResult();
    }

    public void run() {
        bridges = prepareBridge();
        move();
    }

    private List<String> prepareBridge() {
        while (true) {
            try {
                OutputView.printBridgeSize();
                int bridgeSize = InputView.inputBridgeSize();
                return bridgeMaker.makeBridge(bridgeSize);
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void move() {
        upDownBridge = new UpDownBridge(bridges);
        while (true) {
            try {
                OutputView.printSpaceToMove();
                String UorD = InputView.inputSpaceToMove();
                upDownBridge.addBridge(UorD);

                boolean finishFlag = OutputView.printMap(bridges, upDownBridge);
                if (finishFlag) {
                    gameResult.setGameResult("성공");
                    OutputView.printResult(upDownBridge, gameResult.getGameResult(), gameResult.getTotalAttempts());
                    return;
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                retry();
                return;
            }
        }
    }

    public void retry() {
        while (true) {
            try {
                OutputView.printTryAgain();
                String RorQ = InputView.inputTryAgain();
                if (RorQ.equals("R")) {
                    gameResult.addTotalAttempts();
                    reset();
                    move();
                    return;
                }
                if (RorQ.equals("Q")) {
                    OutputView.printResult(upDownBridge, gameResult.getGameResult(), gameResult.getTotalAttempts());
                    return;
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void reset() {
        upDownBridge.setUpBridge(new ArrayList<>());
        upDownBridge.setDownBridge(new ArrayList<>());
    }
}
