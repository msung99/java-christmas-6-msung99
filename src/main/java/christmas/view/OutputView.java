package christmas.view;

import christmas.domain.progress.Badge;
import christmas.domain.progress.Date;
import christmas.domain.progress.EventProgressStatus;
import christmas.domain.progress.Order;
import christmas.domain.progress.Quantity;
import christmas.domain.progress.Amount;
import christmas.domain.menu.Menu;
import christmas.util.StringFormatter;
import java.util.Map;

public class OutputView {
    private static final String DAY_EVENT_INTRO_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_OUTLINE_MESSAGE = "<주문 메뉴>";
    private static final String AMOUNT_BEFORE_DISCOUNT_INTRO_MESSAGE = "\n<할인 전 총주문 금액>";
    private static final String EMPTY_SPACE = " ";
    private static final String COUNT_MESSAGE = "개";
    private static final String CHAMPAGNE_MESSAGE = "샴페인 1개";
    private static final String PRESENT_MESSAGE = "\n<증정 메뉴>";
    private static final String EVENT_LIST_MESSAGE = "\n<혜택 내역>";
    private static final String NOTHING = "없음";
    private static final String TOTAL_DISCOUNT_MESSAGE = "\n<총혜택 금액>";
    private static final String EXPECT_PAYMENT_PRICE = "\n<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "\n<12월 이벤트 배지>";

    public void printMenu(Order order, Date date) {
        printDate(date);
        printOrderItems(order);
    }

    private void printDate(Date date) {
        System.out.println(String.format(DAY_EVENT_INTRO_MESSAGE, date.getDate()));
        System.out.println(ORDER_MENU_OUTLINE_MESSAGE);
    }

    private void printOrderItems(Order order) {
        for (Map.Entry<Menu, Quantity> orderUnit : order.getOrder().entrySet()) {
            Menu menu = orderUnit.getKey();
            Quantity quantity = orderUnit.getValue();
            printItem(menu.getMenuName().getName(), quantity.getQuantity());
        }
    }

    private void printItem(String itemName, int quantity) {
        System.out.println(itemName + EMPTY_SPACE + quantity + COUNT_MESSAGE);
    }

    public void printAmountBeforeDiscount(Amount amount){
        System.out.println(AMOUNT_BEFORE_DISCOUNT_INTRO_MESSAGE);
        System.out.println(StringFormatter.mapTotalAmountoString(amount));
    }

    public void printChampagne(EventProgressStatus eventProgressStatus){
        System.out.println(PRESENT_MESSAGE);
        System.out.println(isPresentChampagne(eventProgressStatus));
    }

    private String isPresentChampagne(EventProgressStatus eventProgressStatus){
        if(eventProgressStatus.isPresentChampagne()) {
            return CHAMPAGNE_MESSAGE;
        }
        return NOTHING;
    }

    public void printDiscountEventLogs(EventProgressStatus eventProgressStatus) {
        System.out.println(EVENT_LIST_MESSAGE);
        System.out.println(getDiscountMessage(eventProgressStatus));

        if (eventProgressStatus.isPresentChampagne()) {
            System.out.println(StringFormatter.mapPresentEventToString(eventProgressStatus));
        }
    }

    public String getDiscountMessage(EventProgressStatus eventProgressStatus) {
        if(eventProgressStatus.isEventActivate()) {
            return StringFormatter.mapDiscountsToString(eventProgressStatus);
        }
        return NOTHING;
    }

    public void printTotalDiscount(EventProgressStatus eventProgressStatus) {
        System.out.println(TOTAL_DISCOUNT_MESSAGE);
        System.out.println(getTotalDiscountMessage(eventProgressStatus));
    }

    public String getTotalDiscountMessage(EventProgressStatus eventProgressStatus) {
        if(eventProgressStatus.isEventActivate()) {
            return StringFormatter.mapPriceToMinusString(eventProgressStatus.getTotalDiscount());
        }
        return StringFormatter.mapPriceBasicToString(eventProgressStatus.getTotalDiscount());
    }

    public void printExpectPaymentPrice(int paymentPrice) {
        System.out.println(EXPECT_PAYMENT_PRICE);
        System.out.println(StringFormatter.mapPriceBasicToString(paymentPrice));
    }

    public void printBadge(Badge badge) {
        System.out.println(BADGE_MESSAGE);
        System.out.println(badge.toString());
    }
}