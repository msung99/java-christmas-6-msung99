package christmas.domain;

import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayDiscountTest {
    @ParameterizedTest
    @DisplayName("평일 날짜에 해당하는 경우 평일 할인이 적용된다.")
    @ValueSource(strings = {"3","4","5","6","7","17","18","19","20","21","24","25","27","28","31"})
    void testSpecialDiscountApply(String date) {
        Discount weekdayDiscount = new WeekdayDiscount();
        Assertions.assertTrue(weekdayDiscount.isEventDay(Date.of(date)));
    }
}
