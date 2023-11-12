package christmas.view;

import christmas.domain.Date;
import christmas.domain.EventProgressStatus;
import christmas.domain.Order;
import christmas.domain.Quantity;
import christmas.domain.Amount;
import christmas.domain.discount.Discount;
import christmas.domain.menu.Menu;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String DAY_EVENT_INTRO_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_OUTLINE_MESSAGE = "<주문 메뉴>";
    private static final String AMOUNT_BEFORE_DISCOUNT_INTRO_MESSAGE = "\n<할인 전 총주문 금액>";
    private static final String EMPTY_SPACE = " ";
    private static final String COUNT_MESSAGE = "개";
    private static final String WON_MESSAGE = "원";
    private static final String CHAMPAGNE_MESSAGE = "샴페인 1개";
    private static final String PRESENT_MESSAGE = "\n<증정 메뉴>";
    private static final String EVENT_LIST_MESSAGE = "\n<혜택 내역>";
    private static final String NOTHING = "없음";
    private static final String MINUS_SIGNAL = "-";

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
        System.out.println(amount.getAmount() + WON_MESSAGE);
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
        for(Discount discount : eventProgressStatus.getDiscounts()) {
            System.out.println(discount.getDateType() + " 할인: "  + MINUS_SIGNAL + discount.getDiscountPrice(eventProgressStatus) + "원");
        }
        if (eventProgressStatus.isPresentChampagne()) {
            System.out.println("증정 이벤트: " + MINUS_SIGNAL + eventProgressStatus.getChampagnePresentPrice() + "원");
        }
    }
}