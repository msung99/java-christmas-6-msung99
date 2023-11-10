package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DateTest {

    @ParameterizedTest
    @DisplayName("숫자외의 형식을 Date 값으로 입력받으면 예외가 발생한다.")
    @ValueSource(strings = {"a", "a1"})
    void testDateNumeric(String number){
        Assertions.assertThatThrownBy(() -> Date.validateNumeric(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
