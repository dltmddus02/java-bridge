package bridge.view.input.exception;

public enum InputErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    INCORRECT_INPUT_FORMAT("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    INTEGER_REQUIRED("숫자만 입력 가능합니다."),
    INVALID_SIZE_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_SPACE_CHARACTER("위: U, 아래: D로 입력해주세요."),
    INVALID_AGAIN_CHARACTER("재시도: R, 종료: Q로 입력해주세요.");
    
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    InputErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
