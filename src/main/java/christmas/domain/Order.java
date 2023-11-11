package christmas.domain;

import christmas.domain.menu.Menu;
import christmas.exception.InvalidOrderException;
import christmas.exception.MaxOrderSizeException;
import christmas.repository.MenuRepository;
import christmas.util.OrderParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<Menu, Quantity> order;
    private static final int MAX_ORDER_SIZE = 20;
    private static final MenuRepository memberRepository = MenuRepository.getInstance();

    private Order(Map<Menu, Quantity> order){
        validateOverSize(order);
        validateOnlyBeverage();
        validateDuplicateMenu(order);
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

    private void validateDuplicateMenu(Map<Menu, Quantity> order) {
        if (order.keySet().size() != order.keySet().stream().distinct().count()) {
            throw new InvalidOrderException();
        }
    }

}
