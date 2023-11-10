package christmas.exception;

public class NumberParseException extends CustomException{
    private static final String ERROR_MESSAGE = "숫자로만 입력해주세요.";
    public NumberParseException(){
        super(ERROR_MESSAGE);
    }
}
