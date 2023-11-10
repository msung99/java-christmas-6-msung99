package christmas.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CountTest {
    @ParameterizedTest
    @DisplayName("메뉴의 개수를 1미만으로 입력하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"0", "-1"})
    void testCountOutOfRange(String count){
        Assertions.assertThatThrownBy(() -> Count.of(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
