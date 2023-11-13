package christmas.domain;

import christmas.domain.progress.Badge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {
    @ParameterizedTest
    @DisplayName("총혜택 금액이 5000~9999원 사이인 경우 별을 부여받는다.")
    @ValueSource(ints = {5000, 6000, 9000, 9999})
    void findStarBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.STAR);
    }

    @ParameterizedTest
    @DisplayName("총혜택 금액이 10000~19999원 사이인 경우 트리를 부여받는다.")
    @ValueSource(ints = {10000, 15000, 19000, 19999})
    void findTreeBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.TREE);
    }
}
