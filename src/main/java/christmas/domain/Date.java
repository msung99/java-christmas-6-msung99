package christmas.domain;

public class Date {
    private final int date;

    private Date(int date){
        this.date = date;
    }

    public static Date of(String date){
        // validateNumeric(date);
        // validateOutOfRange(date);
        return new Date(Integer.parseInt(date));
    }
}
