package bridge.view.input;

import bridge.view.input.exception.InputErrorMessage;
import bridge.view.input.exception.InputException;

public class InputValidator {
    public static void validateBridgeSize(String input) {
        validateNotNullOrEmpty(input);
        validateIntegerAndRange(input);
    }

    public static void validateSpaceToMove(String input) {
        validateNotNullOrEmpty(input);
        if (!input.equals("U") && !input.equals("D")) {
            throw new InputException(InputErrorMessage.INVALID_SPACE_CHARACTER);
        }
    }

    public static void validateTryAgain(String input) {
        validateNotNullOrEmpty(input);
        if (!input.equals("R") && !input.equals("Q")) {
            throw new InputException(InputErrorMessage.INVALID_AGAIN_CHARACTER);
        }
    }

    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateIntegerAndRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException(InputErrorMessage.INTEGER_REQUIRED);
        }
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20) {
            throw new InputException(InputErrorMessage.INVALID_SIZE_RANGE);
        }
    }
}
