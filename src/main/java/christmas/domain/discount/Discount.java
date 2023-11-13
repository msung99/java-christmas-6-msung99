package christmas.domain.discount;

import christmas.domain.progress.Date;
import christmas.domain.progress.EventProgressStatus;
import java.util.List;

public interface Discount {

    int getDiscountPrice(EventProgressStatus eventProgressStatus);
    boolean isEventDay(Date date);
    List<Date> initDays();

    String getDateType();
}
