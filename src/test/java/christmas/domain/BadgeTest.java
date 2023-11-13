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
    void findBadgeTest(int discountPrice) {
        Assertions.assertEquals(Badge.findByValue(discountPrice), Badge.STAR);
    }
}
