package christmas.domain.menu;

import christmas.domain.Quantity;
import java.util.Map;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public Amount plusOrderAmounts(Menu menu, Quantity quantity){
        MenuPrice menuPrice = menu.getPrice();
        return new Amount(amount + getPlusOrderAmount(menuPrice, quantity));
    }

    public int getPlusOrderAmount(MenuPrice menuPrice, Quantity quantity){
        return menuPrice.getPrice() * quantity.getQuantity();
    }
}
