package christmas.domain.event;

import christmas.domain.progress.Amount;
import christmas.domain.progress.Date;
import christmas.domain.progress.Order;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpecialDiscountTest {
    Amount amount = new Amount(10000);
    Order order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

    @ParameterizedTest
    @DisplayName("특별 날짜에 해당하는 경우 할인이 적용된다.")
    @ValueSource(strings = {"3", "10", "17", "24", "25"})
    void testSpecialDiscountApply(String date) {
        Discount specialDiscount = new SpecialDiscount();
        Assertions.assertTrue(specialDiscount.isEventDay(Date.of(date)));
    }
}
