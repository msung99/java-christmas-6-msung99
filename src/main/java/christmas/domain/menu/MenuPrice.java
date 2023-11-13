package christmas.domain.menu;

public class MenuPrice {
    private final int price;

    private MenuPrice(int price) {
        this.price = price;
    }

    public static MenuPrice from(int price) {
        return new MenuPrice(price);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        MenuPrice otherPrice = (MenuPrice) object;
        return this.price == otherPrice.price;
    }

    public int getPrice() {
        return price;
    }
}
