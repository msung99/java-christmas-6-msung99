package christmas.domain;

import christmas.domain.discount.ChirstmasDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChirstmasDiscountTest {
    @ParameterizedTest
    @DisplayName("크리스마스 디데이 이벤트 날짜에 해당하는 경우 크리스마스 디데이 할인이 적용된다.")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "8", "9", "10", "11", "15", "18", "21", "23", "24", "25"})
    void testSpecialDiscountApply(String date) {
        Discount specialDiscount = new ChirstmasDiscount();
        Assertions.assertTrue(specialDiscount.isEventDay(Date.of(date)));
    }
}
