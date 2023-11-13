package christmas.domain;

import christmas.domain.menu.Menu;
import christmas.domain.progress.Amount;
import christmas.domain.progress.Quantity;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {
    @ParameterizedTest
    @DisplayName("주문을 시도하면 주문 금액에다 메뉴 x 개수 값을 누적해서 더한다.")
    @MethodSource("getAmountAndOrderInputs")
    void testPlusOrderAmountTest(Amount amount, Menu menu, Quantity quantity, int result) {
        Assertions.assertEquals(amount.plusOrderAmounts(menu, quantity).getAmount(), result);
    }

    static Stream<Arguments> getAmountAndOrderInputs() {
        return Stream.of(
                Arguments.of(new Amount(10000), Menu.of("제로콜라", 3000), Quantity.of("1"), 13000),
                Arguments.of(new Amount(10000), Menu.of("제로콜라", 3000), Quantity.of("2"), 16000),
                Arguments.of(new Amount(10000),Menu.of("양송이수프", 6000), Quantity.of("1"), 16000),
                Arguments.of(new Amount(10000),Menu.of("양송이수프", 6000), Quantity.of("2"), 22000));
    }
}
