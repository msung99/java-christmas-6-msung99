package christmas.controller;

import christmas.domain.discount.ChirstmasDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.Menu;
import christmas.domain.progress.Amount;
import christmas.domain.progress.Badge;
import christmas.domain.progress.Date;
import christmas.domain.progress.EventProgressStatus;
import christmas.domain.progress.Order;
import christmas.domain.progress.Quantity;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlanController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void runPlanner() {
        Date date = getDate();
        Order order = orderMenu(date);
        Amount amount = getTotalOrderAmounts(order.getOrder());
        EventProgressStatus eventProgressStatus = initEventStatus(amount, date, order);

        if (isEventActivate(amount)) {
            applyDiscountEvent(eventProgressStatus);
        }
        printEventResult(eventProgressStatus);
        outputView.printBadge(getBadge(eventProgressStatus.getTotalDiscount()));
    }

    private void printEventResult(EventProgressStatus eventProgressStatus) {
        outputView.printChampagne(eventProgressStatus);
        outputView.printDiscountEventLogs(eventProgressStatus);
        outputView.printTotalDiscount(eventProgressStatus);
        outputView.printExpectPaymentPrice(eventProgressStatus.getExpectPaymentPrice());
    }

    private Date getDate() {
        try {
            return Date.of(inputView.readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getDate();
        }
    }

    private boolean isEventActivate(Amount amount) {
        return amount.isEventActivate();
    }

    private Order orderMenu(Date date) {
        try {
            Order order = Order.of(inputView.readOrder());
            outputView.printMenu(order, date);
            return order;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return orderMenu(date);
        }
    }

    private Amount getTotalOrderAmounts(Map<Menu, Quantity> order) {
        Amount amount = new Amount(0);
        for (Map.Entry<Menu, Quantity> orderUnit : order.entrySet()) {
            amount = amount.plusOrderAmounts(orderUnit.getKey(), orderUnit.getValue());
        }
        outputView.printAmountBeforeDiscount(amount);
        return amount;
    }

    private EventProgressStatus initEventStatus(Amount amount, Date date, Order order) {
        if (amount.isEventActivate()) {
            return EventProgressStatus.of(amount, date, order);
        }
        return EventProgressStatus.createDeActivate(amount);
    }

    private void applyDiscountEvent(EventProgressStatus eventProgressStatus) {
        tryEachDiscount(eventProgressStatus, new ChirstmasDiscount());
        tryEachDiscount(eventProgressStatus, new WeekdayDiscount());
        tryEachDiscount(eventProgressStatus, new WeekendDiscount());
        tryEachDiscount(eventProgressStatus, new SpecialDiscount());
    }

    private void tryEachDiscount(EventProgressStatus eventProgressStatus, Discount discount) {
        if (discount.isEventDay(eventProgressStatus.getDate())) {
            eventProgressStatus.addDiscount(discount);
        }
    }

    private Badge getBadge(int totalDiscount) {
        return Badge.findByValue(totalDiscount);
    }
}
