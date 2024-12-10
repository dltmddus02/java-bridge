package bridge.domain;

import static bridge.domain.BridgeDirection.fromDirection;

import java.util.ArrayList;
import java.util.List;

public class UpDownBridge {
    List<String> bridges;
    private List<String> upBridge;
    private List<String> downBridge;

    public UpDownBridge(List<String> bridges) {
        this.bridges = bridges;
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public void setDownBridge(List<String> downBridge) {
        this.downBridge = downBridge;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public void setUpBridge(List<String> upBridge) {
        this.upBridge = upBridge;
    }

    public void addBridge(String UorD) {
        int currentIndex = upBridge.size();
        BridgeDirection bridgeDirection = fromDirection(UorD);
        if (!bridges.get(currentIndex).equals(UorD)) {
            if (bridgeDirection.getValue() == 1) {
                upBridge.add("X");
                downBridge.add(" ");
            } else if (bridgeDirection.getValue() == 0) {
                upBridge.add(" ");
                downBridge.add("X");
            }
            return;
        }
        if (bridgeDirection.getValue() == 1) {
            upBridge.add("O");
            downBridge.add(" ");
        } else if (bridgeDirection.getValue() == 0) {
            upBridge.add(" ");
            downBridge.add("O");
        }
    }
}
