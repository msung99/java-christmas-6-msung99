package christmas.domain;

import christmas.domain.menu.Menu;
import christmas.exception.MaxOrderSizeException;
import christmas.util.OrderParser;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Quantity> order;
    private static final int MAX_ORDER_SIZE = 20;

    private Order(Map<Menu, Quantity> order){
        validateOverSize(order);
        validateOnlyBeverage();
        validateDuplicateMenu();
        this.order = new HashMap<>(order);
    }

    public static Order of(String order){
        Map<Menu, Quantity> orders = OrderParser.parseOrderUnits(order);
        validateOverSize(orders);
        return new Order(orders);
    }

    private static void validateOverSize(Map<Menu, Quantity> order) {
        if (order.values().stream().mapToInt(Quantity::getQuantity).sum() > MAX_ORDER_SIZE) {
            throw new MaxOrderSizeException();
        }
    }



    private void validateOnlyBeverage(){
        // TODO: 음료만 주문했는지 검증
    }

    private void validateDuplicateMenu(){
        // TODO: 중복 메뉴가 발생했는지 검증
    }
}
