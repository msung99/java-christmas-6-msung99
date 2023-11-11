package christmas.repository;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private final Map<MenuType, List<Menu>> menus = new HashMap<>();
    private static final MenuRepository menuRepository = new MenuRepository();

    private MenuRepository(){
        menus.put(MenuType.APPETIZER, initAppetizer());
        menus.put(MenuType.MAIN, initMain());
        menus.put(MenuType.DESSERT, initDessert());
        menus.put(MenuType.BEVERAGE, initBeverage());
    }

    public static MenuRepository getInstance(){
        return menuRepository;
    }

    private List<Menu> initAppetizer() {
        return Arrays.asList(Menu.of("양동이수프", 6000),
                Menu.of("타파스", 5500),
                Menu.of("시저셀러드", 8000));
    }

    private List<Menu> initMain(){
        return Arrays.asList(Menu.of("티븐스테이크", 55000),
                Menu.of("바비큐립", 54000),
                Menu.of("해산물파스타", 35000),
                Menu.of("크리스마스파스타", 25000));
    }

    private List<Menu> initDessert(){
        return Arrays.asList(Menu.of("초코케이크", 15000),
                Menu.of("아이스크림", 5000));
    }

    private List<Menu> initBeverage() {
        return Arrays.asList(Menu.of("제로콜라", 3000),
                Menu.of("레드와인", 60000),
                Menu.of("샴페인", 25000));
    }
}