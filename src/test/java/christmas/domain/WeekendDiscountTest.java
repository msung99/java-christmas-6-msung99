package christmas.domain;

import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekendDiscountTest {
    @ParameterizedTest
    @DisplayName("주말 할인을 적용하는 경우 메인 메뉴 개수를 카운팅하여 적용한다")
    @MethodSource("getWeekendOrderInputs")
    void testWeekendOrderTest(String order, int mainCount) {
        WeekendDiscount weekdayDiscount = new WeekendDiscount();
        Assertions.assertEquals(weekdayDiscount.getMainCounts(Order.of(order)), mainCount);
    }

    static Stream<Arguments> getWeekendOrderInputs() {
        return Stream.of(
                Arguments.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", 2),
                Arguments.of("티본스테이크-2,바비큐립-3,초코케이크-2,제로콜라-1", 5),
                Arguments.of("티본스테이크-2,바비큐립-3,해산물파스타-4,제로콜라-1", 9));
    }
}
