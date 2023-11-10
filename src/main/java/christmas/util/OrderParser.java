package christmas.util;

import christmas.domain.Count;
import christmas.domain.Menu;
import christmas.exception.OrderItemParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderParser {
    private static final String ITEM_DELIMITER = ",";
    private static final String UNIT_DELIMITER = "-";
    private static final int ORDER_ITEM_SIZE = 2;

    public static Map<Menu, Count> parseOrderUnits(String input) {
        validateEmptySpace(input);
        Map<Menu, Count> order = new HashMap<>();
        Arrays.stream(input.split(ITEM_DELIMITER)).forEach(item -> {
            Map.Entry<Menu, Count> unit = splitItem(item);
            order.put(unit.getKey(), unit.getValue());
        });
        return order;
    }

    private static Map.Entry<Menu, Count> splitItem(String item) {
        List<String> units = List.of(item.split(UNIT_DELIMITER));
        validateItemSize(units);
        return Map.entry(Menu.of(units.get(0)), Count.of(units.get(1)));
    }

    private static void validateItemSize(List<String> units){
        if (units.size() != ORDER_ITEM_SIZE) {
            throw new OrderItemParseException();
        }
    }

    private static void validateEmptySpace(String input){
        if(input.contains(" ")){
            throw new OrderItemParseException();
        }
    }
}