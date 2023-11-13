package christmas.exception;

public class CustomException extends IllegalArgumentException {
    private static final String COMMON_MESSAGE = "[ERROR] ";

    public CustomException(String errorMessage) {
        super(COMMON_MESSAGE + errorMessage);
    }

}
