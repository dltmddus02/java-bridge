package bridge.domain;

public enum BridgeDirection {
    UP("U", 1), DOWN("D", 0);

    private final String direction;
    private final int value;

    private BridgeDirection(String direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }

    public int getValue() {
        return value;
    }

    public static BridgeDirection fromDirection(String direction) {
        for (BridgeDirection bridgeDirection : BridgeDirection.values()) {
            if (bridgeDirection.getDirection().equals(direction)) {
                return bridgeDirection;
            }
        }
        return null;
    }
}
