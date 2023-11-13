package christmas.exception;

public class OverFlowMenuException extends CustomException {
    private static final String ERROR_MESSAGE = "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";

    public OverFlowMenuException() {
        super(ERROR_MESSAGE);
    }
}
