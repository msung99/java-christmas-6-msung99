package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.EventProgressStatus;
import java.util.List;

public interface Discount {

    int getDiscountPrice(EventProgressStatus eventProgressStatus);
    boolean isEventDay(Date date);
    List<Date> initDays();

    String getDateType();
}
