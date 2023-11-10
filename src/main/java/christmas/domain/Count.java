package christmas.domain;

import christmas.exception.NumberParseException;
import christmas.exception.OrderItemFormatException;

public class Count {
    private final int count;
    private static final int MIN_COUNT = 1;

    private Count(int count){
        validateOutOfRange(count);
        this.count = count;
    }

    public static Count of(String count){
        return new Count(convertedNumber(count));
    }

    private static int convertedNumber(String count){
        try{
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new NumberParseException();
        }
    }

    private static void validateOutOfRange(int count){
        if(count < MIN_COUNT) {
            throw new OrderItemFormatException();
        }
    }
}
