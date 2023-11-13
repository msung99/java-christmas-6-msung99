package christmas.domain.discount;

import christmas.domain.progress.Date;
import christmas.domain.progress.DateType;
import christmas.domain.progress.EventProgressStatus;
import christmas.repository.DateRepository;
import java.util.List;

public class SpecialDiscount implements Discount {
    private List<Date> dates = initDays();
    private static final int DISCOUNT_PRICE = 1000;
    private static final DateRepository dateRepository = DateRepository.getInstance();

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
        return dateRepository.getDatesByType(DateType.SPECITAL);
    }

    @Override
    public String getDateType() {
        return DateType.SPECITAL.toString();
    }
}
