package christmas.domain.discount;

import christmas.domain.Date;
import christmas.domain.DateType;
import christmas.repository.DateRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.crypto.Data;

public class ChirstmasDiscount implements Discount{
    List<Date> dates = initDays();
    private final DateRepository dateRepository = DateRepository.getInstance();

    @Override
    public int getDiscountPrice() {
        return 2023;
    }

    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    @Override
    public List<Date> initDays() {
        return dateRepository.getDatesByType(DateType.D_DAY);
    }
}
