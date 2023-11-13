package christmas.domain.discount;

import christmas.domain.progress.Date;
import christmas.domain.progress.DateType;
import christmas.domain.progress.EventProgressStatus;
import christmas.repository.DateRepository;
import java.util.List;

public class ChirstmasDiscount implements Discount {
    private final List<Date> dates = initDays();
    private static final DateRepository dateRepository = DateRepository.getInstance();
    private static final int BASIC_PRICE = 1000;
    private static final int ADD_PRICE = 100;

    @Override
    public int getDiscountPrice(EventProgressStatus eventProgressStatus) {
        return BASIC_PRICE + (ADD_PRICE * (eventProgressStatus.getDate().getDate() - 1));
    }

    @Override
    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    @Override
    public List<Date> initDays() {
        return dateRepository.getDatesByType(DateType.D_DAY);
    }

    @Override
    public String getDateType() {
        return DateType.D_DAY.toString();
    }
}
