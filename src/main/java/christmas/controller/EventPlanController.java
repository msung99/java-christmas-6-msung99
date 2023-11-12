package christmas.controller;

import christmas.domain.Date;
import christmas.domain.EventProgressStatus;
import christmas.domain.Order;
import christmas.domain.Quantity;
import christmas.domain.Amount;
import christmas.domain.discount.ChirstmasDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.Menu;
import christmas.repository.DateRepository;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void runPlanner(){
        Date date = Date.of(inputView.readDate());
        Order order = orderMenu(date);
        Amount amount = getTotalOrderAmounts(order.getOrder());;

        if (!amount.isEventActivate()) {
            // TODO: 이벤트 적용 없이, "없음" 의 혜택 내역을 보여주기
        }

        EventProgressStatus eventProgressStatus = presentChampagne(amount, date, order);
        discount(eventProgressStatus);
        outputView.printDiscountEventLogs(eventProgressStatus);
        outputView.printTotalDiscount(eventProgressStatus.getTotalDiscount());
        outputView.printExpectPaymentPrice(eventProgressStatus.getExpectPaymentPrice());
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

    private EventProgressStatus presentChampagne(Amount amount, Date date, Order order) {
        EventProgressStatus eventProgressStatus = EventProgressStatus.of(amount, date, order);
        outputView.printChampagne(eventProgressStatus);
        return eventProgressStatus;
    }

    private void discount(EventProgressStatus eventProgressStatus){
        tryEachDiscount(eventProgressStatus, new ChirstmasDiscount());
        tryEachDiscount(eventProgressStatus, new WeekdayDiscount());
        tryEachDiscount(eventProgressStatus, new WeekendDiscount());
        tryEachDiscount(eventProgressStatus, new SpecialDiscount());
    }

    private void tryEachDiscount(EventProgressStatus eventProgressStatus, Discount discount) {
        if(discount.isEventDay(eventProgressStatus.getDate())) {
            eventProgressStatus.addDiscount(discount);
        }
    }
}
