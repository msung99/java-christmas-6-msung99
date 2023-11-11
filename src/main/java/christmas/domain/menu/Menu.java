package christmas.domain.menu;

public class Menu {
    private final MenuName name;
    private final MenuPrice price;

    private Menu(String name, int price){
        this.name = MenuName.from(name);
        this.price = MenuPrice.from(price);
    }

    public static Menu from(String name){
        return findByName(name);
    }

    private static Menu findByName(String name){
        // TODO: 이름으로 찾는 기능 구현
    }

    public static Menu of(String name, int price){
        return new Menu(name, price);
    }
}
