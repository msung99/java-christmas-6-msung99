package christmas.util;

import christmas.domain.Count;
import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderParser {
    private static final String ITEM_DELIMITER = ",";
    private static final String UNIT_DELIMITER = "-";

    public static Map<Menu, Count> parseOrderUnits(String input) {
        return Stream.of(input.split(ITEM_DELIMITER))
                .map(unit -> unit.split(UNIT_DELIMITER))
                .collect(Collectors.toMap(unitArray -> Menu.of(unitArray[0]),
                        unitArray -> Count.of(Integer.parseInt(unitArray[1]))));
    }
}
