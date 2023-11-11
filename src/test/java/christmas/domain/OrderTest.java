package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {

    @ParameterizedTest
    @DisplayName("주문 개수가 20개를 초과하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"티본스테이크-20,바비큐립-1,초코케이크-1", "티본스테이크-5,바비큐립-30,초코케이크-3",
            "티본스테이크-1,바비큐립-1,초코케이크-19"})
    public void testCountOutOfRange(String order){
        Assertions.assertThatThrownBy(() -> Order.of(order))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
