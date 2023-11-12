package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.DateType;
import christmas.domain.EventProgressStatus;
import christmas.repository.DateRepository;
import java.util.List;

public class ChirstmasDiscount implements Discount{
    private final List<Date> dates = initDays();
    private final Date date;
    private final DateRepository dateRepository = DateRepository.getInstance();
    private static final int BASIC_PRICE = 1000;
    private static final int ADD_PRICE = 100;

    public ChirstmasDiscount(EventProgressStatus eventProgressStatus) {
        this.date = eventProgressStatus.getDate();
    }

    @Override
    public int getDiscountPrice(Date date) {
        return BASIC_PRICE + (ADD_PRICE * (date.getDate()) -1);
    }

    @Override
    public int getDiscountPrice() {
        return -1;
    }

    @Override
    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    @Override
    public List<Date> initDays() {
        return dateRepository.getDatesByType(DateType.D_DAY);
    }
}
