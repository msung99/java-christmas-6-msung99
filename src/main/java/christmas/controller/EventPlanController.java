package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.Quantity;
import christmas.domain.menu.Amount;
import christmas.domain.menu.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void runPlanner(){
        Date date = Date.of(inputView.readDate());
        Order order = orderMenu(date);
        Amount amount = getTotalOrderAmounts(order.getOrder());

        if (amount.isEventActivate()) {
            // TODO: 이벤트, 할인 적용 기능 구현
        }
    }

    private Order orderMenu(Date date){
        Order order = Order.of(inputView.readOrder());
        outputView.printMenu(order, date);
        return order;
    }

    private Amount getTotalOrderAmounts(Map<Menu, Quantity> order){
        Amount amount = new Amount(0);
        for(Map.Entry<Menu, Quantity> orderUnit : order.entrySet()){
            amount = amount.plusOrderAmounts(orderUnit.getKey(), orderUnit.getValue());
        }
        outputView.printAmountBeforeDiscount(amount);
        return amount;
    }
}
