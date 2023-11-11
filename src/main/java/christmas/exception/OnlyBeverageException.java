package christmas.exception;

public class OnlyBeverageException extends CustomException{
    private static final String ERROR_MESSAGE = "음료만 주문 시, 주문할 수 없습니다.";
    public OnlyBeverageException(){
        super(ERROR_MESSAGE);
    }
}
