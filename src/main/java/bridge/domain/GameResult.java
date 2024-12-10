package bridge.domain;

public class GameResult {
    String gameResult;
    Integer totalAttempts;

    public GameResult() {
        this.gameResult = "실패";
        this.totalAttempts = 1;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public Integer getTotalAttempts() {
        return totalAttempts;
    }

    public void addTotalAttempts() {
        this.totalAttempts += 1;
    }
}
