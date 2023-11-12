package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Date;
import christmas.domain.EventProgressStatus;
import christmas.domain.Order;
import christmas.domain.discount.ChirstmasDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ChirstmasDiscountTest {
    Discount discount;
    EventProgressStatus eventProgressStatus;
    Amount amount;
    Order order;

    @BeforeEach
    void setUp() {
        discount = new ChirstmasDiscount();
        amount = new Amount(10000);
        order = Order.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
    }

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 이벤트 적용 기간인 경우 이벤트 혜택이 적용된다.")
    @MethodSource("getChirstmasDDayOrderInputs")
    void testChirstmasDiscountApplyTest(String date, int discountPrice) {
        eventProgressStatus = EventProgressStatus.of(amount, Date.of(date), order);
        Assertions.assertEquals(discount.getDiscountPrice(eventProgressStatus), discountPrice);
    }

    static Stream<Arguments> getChirstmasDDayOrderInputs() {
        return Stream.of(
                Arguments.of("1", 1000),
                Arguments.of("2", 1100),
                Arguments.of("3", 1200),
                Arguments.of("7", 1600),
                Arguments.of("11", 2000),
                Arguments.of("24", 3300),
                Arguments.of("25", 3400));
    }

    @ParameterizedTest
    @DisplayName("크리스마스 디데이 이벤트 날짜에 해당하는 경우 크리스마스 디데이 할인이 적용된다.")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "8", "9", "10", "11", "15", "18", "21", "23", "24", "25"})
    void testSpecialDiscountApply(String date) {
        Assertions.assertTrue(discount.isEventDay(Date.of(date)));
    }
}
