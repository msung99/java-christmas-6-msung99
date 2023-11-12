package christmas.domain.discount;

import christmas.domain.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.crypto.Data;

public class ChirstmasDiscount implements Discount{
    List<Date> dates = initDDay();

    @Override
    public int getDiscountPrice() {
        return 2023;
    }

    public boolean isEventDay(Date date) {
        return dates.contains(date);
    }

    private List<Date> initDDay() {
        return IntStream.rangeClosed(1, 25)
                .mapToObj(i -> Date.of(String.valueOf(i)))
                .collect(Collectors.toList());
    }
}
