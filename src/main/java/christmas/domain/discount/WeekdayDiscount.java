package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.DateType;
import christmas.repository.DateRepository;
import java.util.ArrayList;
import java.util.List;

public class WeekdayDiscount implements Discount{
    List<Date> dates = new ArrayList<>();
    DateRepository dateRepository = DateRepository.getInstance();
    private static final int DISCOUNT_PRICE = 2023;

    @Override
    public int getDiscountPrice() {
        return DISCOUNT_PRICE;
    }

    @Override
    public int getDiscountPrice(Date date) {
        return -1;
    }

    @Override
    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    @Override
    public List<Date> initDays() {
        return dateRepository.getDatesByType(DateType.WEEKDAY);
    }
}
