package christmas.domain.discount;

import christmas.domain.Date;
import christmas.repository.DateRepository;
import java.util.ArrayList;
import java.util.List;

public interface Discount {

    int getDiscountPrice();
    boolean isEventDay(Date date);
    List<Date> initDays();
}
