package christmas.domain.progress;

import christmas.exception.InvalidDateException;

public class Date {
    private final int date;
    private static final int MAX_DATE = 31;
    private static final int MIN_DATE = 1;

    private Date(int date) {
        this.date = date;
    }

    public static Date of(String date) {
        validateNumeric(date);
        int parsedInput = Integer.parseInt(date);
        validateOutOfRange(parsedInput);
        return new Date(parsedInput);
    }

    private static void validateNumeric(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new InvalidDateException();
        }
    }

    private static void validateOutOfRange(int date) {
        if (date > MAX_DATE || date < MIN_DATE) {
            throw new InvalidDateException();
        }
    }

    public int getDate() {
        return date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Date otherDate = (Date) object;
        return date == otherDate.date;
    }
}
