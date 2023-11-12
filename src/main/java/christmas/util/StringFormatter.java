package christmas.util;

import christmas.domain.EventProgressStatus;
import christmas.domain.discount.Discount;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class StringFormatter {
    public enum Format {
        EVENT_DISCOUNT_RESULT_FORMAT("%s 할인: -%,d원  \n"),
        REWARD_RATE_FORMAT("#,##0.0");

        private final String format;

        Format(String format) {
            this.format = format;
        }

        public String toString() {
            return this.format;
        }
    }

    public static String mapDiscountsToString(EventProgressStatus eventProgressStatus){
        StringBuilder result = new StringBuilder();
        for(Discount discount : eventProgressStatus.getDiscounts()) {
            result.append(
                    String.format(Format.EVENT_DISCOUNT_RESULT_FORMAT.toString(),
                            discount.getDateType(),
                            discount.getDiscountPrice(eventProgressStatus)));
        }
        return result.toString();
    }

    public static String mapPriceToString(int price) {
        return new DecimalFormat(Format.REWARD_RATE_FORMAT.format).format(price);
    }
}
