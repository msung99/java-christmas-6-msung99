package christmas.domain;

import christmas.exception.NumberParseException;
import christmas.exception.InvalidOrderException;

public class Quantity {
    private final int quantity;
    private static final int MIN_COUNT = 1;

    private Quantity(int quantity){
        validateOutOfRange(quantity);
        this.quantity = quantity;
    }

    public static Quantity of(String quantity){
        return new Quantity(convertedNumber(quantity));
    }

    private static int convertedNumber(String quantity){
        try{
            return Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new InvalidOrderException();
        }
    }

    private static void validateOutOfRange(int quantity){
        if(quantity < MIN_COUNT) {
            throw new InvalidOrderException();
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
