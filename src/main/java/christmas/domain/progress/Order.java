package christmas.domain.progress;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.exception.InvalidOrderException;
import christmas.exception.OnlyBeverageException;
import christmas.exception.OverFlowMenuException;
import christmas.repository.MenuRepository;
import christmas.util.OrderParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {
    private final Map<Menu, Quantity> order;
    private static final int MAX_ORDER_SIZE = 20;
    private static final MenuRepository menuRepository = MenuRepository.getInstance();

    private Order(Map<Menu, Quantity> order) {
        validateOverSize(order);
        validateOnlyBeverage(order.keySet());
        this.order = new HashMap<>(order);
    }

    public static Order of(String order) {
        Map<Menu, Quantity> orders = OrderParser.parseOrderUnits(order);
        validateOverSize(orders);
        return new Order(orders);
    }

    private static void validateOverSize(Map<Menu, Quantity> order) {
        if (order.values().stream().mapToInt(Quantity::getQuantity).sum() > MAX_ORDER_SIZE) {
            throw new OverFlowMenuException();
        }
    }

    private void validateOnlyBeverage(Set<Menu> orderMenus) {
        if (orderMenus.stream().noneMatch(menu -> menuRepository.findTypeByMenu(menu) != MenuType.BEVERAGE)) {
            throw new OnlyBeverageException();
        }
    }

    public Map<Menu, Quantity> getOrder() {
        return order;
    }

    public List<Menu> getMenus() {
        return new ArrayList<>(order.keySet());
    }

}
