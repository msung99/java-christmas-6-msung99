package christmas.view;

import christmas.domain.Order;
import christmas.domain.Quantity;
import christmas.domain.menu.Menu;
import java.util.Map;
import org.mockito.internal.matchers.Or;

public class OutputView {
    public void printMenu(Order order) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        for(Map.Entry<Menu, Quantity> orderUnit : order.getOrder().entrySet()) {
            Menu menu = orderUnit.getKey();
            Quantity quantity = orderUnit.getValue();
            System.out.println(menu.getName().getName() + " " + quantity.getQuantity() + "개");
        }
    }
}
