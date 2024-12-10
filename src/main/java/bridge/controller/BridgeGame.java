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
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker;
    List<String> bridges;
    UpDownBridge upDownBridge;
    GameResult gameResult;

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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move() {
//        List<String> userBridges = new ArrayList<>();
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

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
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
