package christmas.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuantityTest {
    @ParameterizedTest
    @DisplayName("메뉴의 개수를 1미만으로 입력하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"0", "-1"})
    void testCountOutOfRange(String count){
        Assertions.assertThatThrownBy(() -> Quantity.of(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력ㅇ받은 메뉴의 개수가 숫자 형식이 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"a1", "b", "12c3"})
    void testCountParse(String count){
        Assertions.assertThatThrownBy(() -> Quantity.of(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
