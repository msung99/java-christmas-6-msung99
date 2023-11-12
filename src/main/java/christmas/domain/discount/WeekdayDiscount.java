package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.DateType;
import christmas.repository.DateRepository;
import java.util.ArrayList;
import java.util.List;

public class WeekdayDiscount implements Discount{
    List<Date> dates = new ArrayList<>();
    DateRepository dateRepository = DateRepository.getInstance();

    @Override
    public int getDiscountPrice() {
        return 2023;
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
