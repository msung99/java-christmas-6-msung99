package christmas.domain.discount;

import christmas.domain.Date;

public class WeekdayDiscount implements Discount{
    @Override
    public int getDiscountPrice() {
        // TODO: 주중 할인 구현
    }

    @Override
    public boolean isEventDay(Date date) {
        // TODO: 주중 할인 구현
    }
}
