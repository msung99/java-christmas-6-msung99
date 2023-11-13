package christmas.domain;

import christmas.domain.discount.Discount;
import java.util.ArrayList;
import java.util.List;

public class EventProgressStatus {
    private final Amount amount;
    private final Date date;
    private final Order order;
    private List<Discount> discounts = new ArrayList<>();
    private final boolean isPresentChampagne;
    private boolean isEventActivate = true;
    private static final int PRESENT_CHAMPAGNE_MIN_PRICE = 120000;
    private static final int CHAMPAGNE_PRESENT_PRICE = 25000;

    private EventProgressStatus(Amount amount, Date date, Order order){
        this.amount = amount;
        this.date = date;
        this.order = order;
        this.isPresentChampagne = setPresentChampagne(amount);
    }

    private EventProgressStatus(Amount amount) {
        this.amount = amount;
        this.date = null;
        this.order = null;
        this.isPresentChampagne = setPresentChampagne(amount);
        this.isEventActivate = false;
    }

    public static EventProgressStatus of(Amount amount, Date date, Order order) {
        return new EventProgressStatus(amount, date, order);
    }

    public static EventProgressStatus createDeActivate(Amount amount) {
        return new EventProgressStatus(amount);
    }

    public int getTotalDiscount() {
        int totalDiscount = discounts.stream()
                .mapToInt(discount -> discount.getDiscountPrice(this)).sum();
        totalDiscount += getPresentPrice();
        return totalDiscount;
    }

    public int getTotalDiscountWithoutPresent() {
        return discounts.stream()
                .mapToInt(discount -> discount.getDiscountPrice(this)).sum();
    }

    private int getPresentPrice () {
        if (isPresentChampagne) {
            return CHAMPAGNE_PRESENT_PRICE;
        }
        return 0;
    }

    private boolean setPresentChampagne(Amount amount) {
        return amount.getAmount() >= PRESENT_CHAMPAGNE_MIN_PRICE;
    }

    public boolean isPresentChampagne() {
        return isPresentChampagne;
    }

    public int getChampagnePresentPrice() {
        return CHAMPAGNE_PRESENT_PRICE;
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

    public Order getOrder() {
        return order;
    }

    public int getExpectPaymentPrice() {
        return amount.getAmount() - getTotalDiscountWithoutPresent();
    }

    public Amount getAmount() {
        return amount;
    }

    public boolean isEventActivate() {
        return isEventActivate;
    }
}
