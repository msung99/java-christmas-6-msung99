package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.DateType;
import christmas.domain.EventProgressStatus;
import christmas.domain.Order;
import christmas.domain.menu.MenuType;
import christmas.repository.DateRepository;
import christmas.repository.MenuRepository;
import java.util.List;

public class WeekendDiscount implements Discount{
    private List<Date> dates = initDays();
    private static final int DISCOUNT_PRICE = 2023;
    private static final DateRepository dateRepository = DateRepository.getInstance();
    private static final MenuRepository menuRepository = MenuRepository.getInstance();

    @Override
    public int getDiscountPrice(EventProgressStatus eventProgressStatus) {
        return DISCOUNT_PRICE * getMainCounts(eventProgressStatus.getOrder());
    }

    private int getMainCounts(Order order) {
        return order.getOrder().entrySet().stream()
                .filter(entry -> menuRepository.findTypeByMenu(entry.getKey()) == MenuType.MAIN)
                .mapToInt(entry -> entry.getValue().getQuantity())
                .sum();
    }

    @Override
    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    @Override
    public List<Date> initDays() {
        return dateRepository.getDatesByType(DateType.WEEKEND);
    }
}
