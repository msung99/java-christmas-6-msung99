package christmas.domain.menu;

import java.util.List;

public enum MenuType {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String type;

    MenuType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
