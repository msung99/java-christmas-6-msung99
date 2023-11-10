package christmas.domain;

public class Menu {
    private String name;
    private Menu(String name){
        this.name = name;
    }

    public static Menu of(String name){
        return new Menu(name);
    }
}
