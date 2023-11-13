package christmas.domain.progress;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuPrice;

public class Amount {
    private final int amount;
    private static final int EVENT_ACTIVATE_MIN_AMOUNT = 10000;

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

    public int getAmount() {
        return amount;
    }

    public boolean isEventActivate(){
        return amount >= EVENT_ACTIVATE_MIN_AMOUNT;
    }
}
