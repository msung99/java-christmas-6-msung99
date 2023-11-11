package christmas.domain.menu;

import christmas.repository.MenuRepository;
import java.util.Objects;

public class Menu {
    private final MenuName name;
    private final MenuPrice price;
    private static final MenuRepository menuRepository = MenuRepository.getInstance();

    private Menu(String name, int price){
        this.name = MenuName.from(name);
        this.price = MenuPrice.from(price);
    }

    public static Menu from(String name){
        return findByName(name);
    }

    private static Menu findByName(String name){
        return menuRepository.findByName(name);
    }

    public static Menu of(String name, int price){
        return new Menu(name, price);
    }

    public MenuName getMenuName() {
        return name;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null || getClass() != object.getClass()){
            return false;
        }
        Menu otherMenu = (Menu) object;
        return name.equals(otherMenu.name) && price.equals(otherMenu.price);
    }


}
