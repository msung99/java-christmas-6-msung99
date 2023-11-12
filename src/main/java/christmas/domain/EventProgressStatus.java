package christmas.domain;

import christmas.domain.discount.Discount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mockito.internal.matchers.Or;

public class EventProgressStatus {
    private final Amount amount;
    private final Date date;
    private final Order order;
    private List<Discount> discounts = new ArrayList<>();

    private final boolean isPresentChampagne;
    private static final int PRESENT_CHAMPAGNE_MIN_PRICE = 120000;

    private EventProgressStatus(Amount amount, Date date, Order order){
        this.amount = amount;
        this.date = date;
        this.order = order;
        this.isPresentChampagne = setPresentChampagne(amount);
    }

    public static EventProgressStatus of(Amount amount, Date date, Order order){
        return new EventProgressStatus(amount, date, order);
    }


    private boolean setPresentChampagne(Amount amount) {
        return amount.getAmount() >= PRESENT_CHAMPAGNE_MIN_PRICE;
    }

    public boolean isPresentChampagne() {
        return isPresentChampagne;
    }

    public Date getDate() {
        return date;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
