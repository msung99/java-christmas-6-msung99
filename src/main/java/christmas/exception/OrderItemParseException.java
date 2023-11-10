package christmas.exception;

public class OrderItemParseException extends CustomException{
    private static final String ERROR_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public OrderItemParseException(){
        super(ERROR_MESSAGE);
    }
}
