package christmas.util;

import christmas.domain.Amount;
import christmas.domain.EventProgressStatus;
import christmas.domain.discount.Discount;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class StringFormatter {
    private static final String TOTAL_AMOUNT_FORMAT = "%,d원";
    private static final String TOTAL_DISCOUNT_FORMAT = "-%,d원";

    private static final String EVENT_DISCOUNT_RESULT_FORMAT = "%s 할인: -%,d원\n";
    private static final String PRESENT_RESULT_FORMAT = "증정 이벤트: -%,d원";

    public static String mapDiscountsToString(EventProgressStatus eventProgressStatus){
        StringBuilder result = new StringBuilder();
        addDiscountResult(result, eventProgressStatus);
        return result.toString();
    }

    private static void addDiscountResult(StringBuilder result, EventProgressStatus eventProgressStatus) {
        List<Discount> discounts = eventProgressStatus.getDiscounts();
        int size = discounts.size();
        for (int i = 0; i < size; i++) {
            Discount discount = discounts.get(i);
            result.append(String.format(EVENT_DISCOUNT_RESULT_FORMAT,
                    discount.getDateType(),
                    discount.getDiscountPrice(eventProgressStatus)));
            if (i == size - 1) {
                result.delete(result.length() - 1, result.length());
            }
        }
    }

    public static String mapPresentEventToString(EventProgressStatus eventProgressStatus){
        return String.format(PRESENT_RESULT_FORMAT, eventProgressStatus.getChampagnePresentPrice());
    }

    public static String mapTotalAmountToString(Amount amount) {
        return String.format(TOTAL_AMOUNT_FORMAT, amount.getAmount());
    }

    public static String mapTotalDiscountToString(int discount) {
        return String.format(TOTAL_DISCOUNT_FORMAT, discount);
    }
}
