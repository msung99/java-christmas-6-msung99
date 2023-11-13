package christmas.domain.discount;

import christmas.domain.progress.Date;
import christmas.domain.progress.DateType;
import christmas.domain.progress.EventProgressStatus;
import christmas.domain.progress.Order;
import christmas.domain.menu.MenuType;
import christmas.repository.DateRepository;
import christmas.repository.MenuRepository;
import java.util.List;

public class WeekdayDiscount implements Discount{
    private List<Date> dates = initDays();
    private static final DateRepository dateRepository = DateRepository.getInstance();
    private static final MenuRepository menuRepository = MenuRepository.getInstance();
    private static final int DISCOUNT_PRICE = 2023;

    @Override
    public int getDiscountPrice(EventProgressStatus eventProgressStatus) {
        return DISCOUNT_PRICE * getDessertCounts(eventProgressStatus.getOrder());
    }

    public int getDessertCounts(Order order) {
        return order.getOrder().entrySet().stream()
                .filter(entry -> menuRepository.findTypeByMenu(entry.getKey()) == MenuType.DESSERT)
                .mapToInt(entry -> entry.getValue().getQuantity())
                .sum();
    }


    @Override
    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    @Override
    public List<Date> initDays() {
        return dateRepository.getDatesByType(DateType.WEEKDAY);
    }

    @Override
    public String getDateType() {
        return DateType.WEEKDAY.toString();
    }
}
