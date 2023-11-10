package christmas.domain;

import christmas.util.OrderParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderParserTest {
    @ParameterizedTest
    @DisplayName("구분자 , 를 생략하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"티본스테이크-1바비큐립-1,초코케이크-2,제로콜라-1", "티본스테이크-1,바비큐립-1,초코케이크-2제로콜라-1",
            "티본스테이크-1,바비큐립-1,초코케이크-2제로콜라-1,", ",티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"})
    void testOrderParseSkipUnitDelimiter(String input){
        Assertions.assertThatThrownBy(() -> OrderParser.parseOrderUnits(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구분자 - 를 생략하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"티본스테이크-1,바비큐립1,초코케이크-2,제로콜라1", "티본스테이크1,바비큐립-1,초코케이크-2,제로콜라-1",
    "-티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"})
    void testOrderParseSkipUnitDelimite2r(String input){
        Assertions.assertThatThrownBy(() -> OrderParser.parseOrderUnits(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("공백을 입력 중간에 포함하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1 ", "티본스테이크-1, 바비큐립-1,초코케이크  -2,제로콜라-1"})
    void testOrderParseWithEmptySpace(String input){
        Assertions.assertThatThrownBy(() -> OrderParser.parseOrderUnits(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("공백을 입력하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "    "})
    void testOrderParseWithNothing(String input){
        Assertions.assertThatThrownBy(() -> OrderParser.parseOrderUnits(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
