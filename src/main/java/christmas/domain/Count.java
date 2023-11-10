package christmas.domain;

import christmas.exception.NumberParseException;

public class Count {
    private int count;

    private Count(int count){
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
}
