package christmas;

import christmas.controller.EventPlanController;

public class Application {
    public static void main(String[] args) {
        EventPlanController eventPlanController = new EventPlanController();
        eventPlanController.runPlanner();
    }
}
