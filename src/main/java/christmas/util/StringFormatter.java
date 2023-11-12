package christmas.util;

import christmas.domain.Amount;
import christmas.domain.EventProgressStatus;
import christmas.domain.discount.Discount;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class StringFormatter {
    private static final String TOTAL_AMOUNT_FORMAT = "%,d원\n";
    private static final String EVENT_DISCOUNT_RESULT_FORMAT = "%s 할인: -%,d원\n";
    private static final String PRESENT_RESULT_FORMAT = "증정 이벤트: -%,d원\n";

    public static String mapDiscountsToString(EventProgressStatus eventProgressStatus){
        StringBuilder result = new StringBuilder();
        addDiscountResult(result, eventProgressStatus);
        return result.toString();
    }

    private static void addDiscountResult(StringBuilder result, EventProgressStatus eventProgressStatus) {
        for(Discount discount : eventProgressStatus.getDiscounts()) {
            result.append(String.format(EVENT_DISCOUNT_RESULT_FORMAT,
                    discount.getDateType(),
                    discount.getDiscountPrice(eventProgressStatus)));
        }
    }

    public static String mapPresentEventToString(EventProgressStatus eventProgressStatus){
        return String.format(PRESENT_RESULT_FORMAT, eventProgressStatus.getChampagnePresentPrice());
    }

    public static String mapTotalAmountToString(Amount amount) {
        return String.format(TOTAL_AMOUNT_FORMAT, amount.getAmount());
    }
}
