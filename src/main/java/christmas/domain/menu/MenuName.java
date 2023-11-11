package christmas.domain.menu;

public class MenuName {
    private final String name;

    private MenuName(String name){
        this.name = name;
    }

    public static MenuName from(String name) {
        return new MenuName(name);
    }
}
