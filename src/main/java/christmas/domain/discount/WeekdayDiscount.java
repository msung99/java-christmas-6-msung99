package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.DateType;
import christmas.domain.EventProgressStatus;
import christmas.repository.DateRepository;
import java.util.ArrayList;
import java.util.List;

public class WeekdayDiscount implements Discount{
    private List<Date> dates = initDays();
    private static final DateRepository dateRepository = DateRepository.getInstance();
    private static final int DISCOUNT_PRICE = 2023;

    @Override
    public int getDiscountPrice(EventProgressStatus eventProgressStatus) {
        return DISCOUNT_PRICE;
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
