package christmas.domain.menu;

public class MenuPrice {
    private final int price;

    private MenuPrice(int price){
        this.price = price;
    }

    public static MenuPrice from(int price){
        return new MenuPrice(price);
    }
}
