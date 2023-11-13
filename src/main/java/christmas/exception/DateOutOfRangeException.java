package christmas.exception;

public class DateOutOfRangeException extends CustomException {
    private static final String ERROR_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public DateOutOfRangeException() {
        super(ERROR_MESSAGE);
    }
}
