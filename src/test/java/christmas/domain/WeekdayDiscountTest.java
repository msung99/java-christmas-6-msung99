package christmas.domain;

import christmas.domain.discount.Discount;
import christmas.domain.discount.WeekdayDiscount;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayDiscountTest {
    @ParameterizedTest
    @DisplayName("평일 날짜에 해당하는 경우 평일 할인이 적용된다.")
    @ValueSource(strings = {"3","4","5","6","7","17","18","19","20","21","24","25","27","28","31"})
    void testSpecialDiscountApply(String date) {
        Discount weekdayDiscount = new WeekdayDiscount();
        Assertions.assertTrue(weekdayDiscount.isEventDay(Date.of(date)));
    }

    @ParameterizedTest
    @DisplayName("평일 할인을 적용하는 경우 디저트 메뉴 개수를 카운팅하여 적용한다")
    @MethodSource("getWeekdayOrderInputs")
    void testWeekdayOrderTest(String order, int dessertCount) {
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
        Assertions.assertEquals(weekdayDiscount.getDessertCounts(Order.of(order)), dessertCount);
    }

    static Stream<Arguments> getWeekdayOrderInputs() {
        return Stream.of(
                Arguments.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", 2),
                Arguments.of("티본스테이크-1,바비큐립-1,초코케이크-3,제로콜라-1", 3),
                Arguments.of("티본스테이크-1,아이스크림-2,초코케이크-3,제로콜라-1", 5));
    }
}
