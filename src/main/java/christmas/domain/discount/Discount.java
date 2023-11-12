package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.EventProgressStatus;
import christmas.repository.DateRepository;
import java.util.ArrayList;
import java.util.List;

public interface Discount {

    int getDiscountPrice(EventProgressStatus eventProgressStatus);
    boolean isEventDay(Date date);
    List<Date> initDays();

    String getDateType();
}
