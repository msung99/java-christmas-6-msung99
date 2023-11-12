package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class EventProgressStatus {
    private final Amount amount;
    private final Date date;
    private final Map<DateType, EventPrice> eventList = new HashMap<>();
    private final boolean isPresentChampagne;
    private static final int PRESENT_CHAMPAGNE_MIN_PRICE = 120000;

    private EventProgressStatus(Amount amount, Date date){
        this.amount = amount;
        this.date = date;
        this.isPresentChampagne = setPresentChampagne(amount);
    }

    public static EventProgressStatus of(Amount amount, Date date){
        return new EventProgressStatus(amount, date);
    }


    private boolean setPresentChampagne(Amount amount) {
        return amount.getAmount() >= PRESENT_CHAMPAGNE_MIN_PRICE;
    }
}
