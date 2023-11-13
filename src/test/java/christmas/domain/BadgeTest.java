package christmas.domain;

import christmas.domain.progress.Badge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {
    @ParameterizedTest
    @DisplayName("총혜택 금액이 5000~9999원 사이인 경우 별 배지을 부여받는다.")
    @ValueSource(ints = {5000, 6000, 9000, 9999})
    void findStarBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.STAR);
    }

    @ParameterizedTest
    @DisplayName("총혜택 금액이 10000~19999원 사이인 경우 트리 배지를 부여받는다.")
    @ValueSource(ints = {10000, 15000, 19000, 19999})
    void findTreeBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.TREE);
    }

    @ParameterizedTest
    @DisplayName("총혜택 금액이 20000원 이상인 경우 산타 배지를 부여받는다.")
    @ValueSource(ints = {20000, 109000, 500200, 9999999})
    void findSantaBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.SANTA);
    }

    @ParameterizedTest
    @DisplayName("총혜택 금액이 5000원 미만인 경우 배지를 부여받지 않는다.")
    @ValueSource(ints = {0, 1000, 4000, 4999})
    void findNothingBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.NOTHING);
    }
}
