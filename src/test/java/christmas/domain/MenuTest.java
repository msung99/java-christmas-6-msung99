package christmas.domain;

import christmas.domain.menu.Menu;
import christmas.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    @ParameterizedTest
    @DisplayName("메뉴판에 없는 메뉴를 입력받은 경우 예외가 발생한다.")
    @ValueSource(strings = {"대학교 학식", "우테코 푸드", "팹시콜라"})
    void testCountParse(String name){
        Assertions.assertThatThrownBy(() -> Menu.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
