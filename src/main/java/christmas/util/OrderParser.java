package christmas.util;

import christmas.domain.Quantity;
import christmas.domain.menu.Menu;
import christmas.exception.InvalidOrderException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderParser {
    private static final String ITEM_DELIMITER = ",";
    private static final String UNIT_DELIMITER = "-";
    private static final int ORDER_ITEM_SIZE = 2;

    public static Map<Menu, Quantity> parseOrderUnits(String input) {
        validateEmptySpace(input);
        Map<Menu, Quantity> order = new HashMap<>();
        Arrays.stream(input.split(ITEM_DELIMITER)).forEach(item -> {
            Map.Entry<Menu, Quantity> unit = splitItem(item);
            order.put(unit.getKey(), unit.getValue());
        });
        return order;
    }

    private static Map.Entry<Menu, Quantity> splitItem(String item) {
        List<String> units = List.of(item.split(UNIT_DELIMITER));
        validateItemSize(units);
        System.out.println("===============================6666");
        return Map.entry(Menu.from(units.get(0)), Quantity.of(units.get(1)));
    }

    private static void validateItemSize(List<String> units){
        if (units.size() != ORDER_ITEM_SIZE) {
            System.out.println("oijqwoieqoiejoiqwejioqwjoiqwjoieoqiwje");
            throw new InvalidOrderException();
        }
    }

    private static void validateEmptySpace(String input){
        if(input.contains(" ")){
            throw new InvalidOrderException();
        }
    }
}