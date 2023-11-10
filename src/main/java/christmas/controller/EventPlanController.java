package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void runPlanner(){
        initDatas();
        Date date = Date.of(inputView.readDate());
    }

    private void initDatas(){
        // TODO: 기본 데이터 초기화
    }
}
