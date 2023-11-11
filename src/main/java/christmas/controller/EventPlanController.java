package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void runPlanner(){
        initDatas();
        Date date = Date.of(inputView.readDate());
        Order order = orderMenu(date);
    }

    private void initDatas(){
        // TODO: 기본 데이터 초기화
    }

    private Order orderMenu(Date date){
        Order order = Order.of(inputView.readOrder());
        outputView.printMenu(order, date);
        return order;
    }
}
