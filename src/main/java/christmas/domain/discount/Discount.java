package christmas.domain.discount;

import christmas.domain.Date;

public interface Discount {
    int getDiscountPrice();
    boolean isEventDay(Date date);
}
