package christmas.domain;

import christmas.util.OrderParser;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Count> order;

    private Order(Map<Menu, Count> order){
        this.order = new HashMap<>(order);
    }

    public static Order of(String order){
        return new Order(OrderParser.parseOrderUnits(order));
    }
}
