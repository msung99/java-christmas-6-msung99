package christmas.domain.menu;

import christmas.repository.MenuRepository;

public class Menu {
    private final MenuName name;
    private final MenuPrice price;
    private final MenuRepository menuRepository = MenuRepository.getInstance();

    private Menu(String name, int price){
        this.name = MenuName.from(name);
        this.price = MenuPrice.from(price);
    }

    public static Menu from(String name){
        return findByName(name);
    }

    private static Menu findByName(String name){
        // TODO: 이름으로 찾는 기능 구현
        // 1. 만약에 해당하는 이름이 없다면 예외 발생
        // 2. 그게 아니라면 Menu 생성하기
        menuRepository.
    }

    public static Menu of(String name, int price){
        return new Menu(name, price);
    }

    public MenuName getName() {
        return name;
    }
}
