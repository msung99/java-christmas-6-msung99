package christmas.domain;

public class Menu {
    private final Name name;

    private Menu(String name){
        this.name = Name.of(name);
    }

    public static Menu of(String name){
        return new Menu(name);
    }
}
