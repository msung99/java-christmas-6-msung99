package christmas.view;

import christmas.domain.Order;
import christmas.domain.Quantity;
import christmas.domain.menu.Menu;
import java.util.Map;

public class OutputView {
    private static final String DAY_EVENT_INTRO_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_OUTLINE_MESSAGE = "<주문 메뉴>";

    public void printMenu(Order order) {
        System.out.println(DAY_EVENT_INTRO_MESSAGE);
        System.out.println(ORDER_MENU_OUTLINE_MESSAGE);
        for(Map.Entry<Menu, Quantity> orderUnit : order.getOrder().entrySet()) {
            Menu menu = orderUnit.getKey();
            Quantity quantity = orderUnit.getValue();
            System.out.println(menu.getName().getName() + " " + quantity.getQuantity() + "개");
        }
    }
}
