package christmas.domain;

import jdk.jfr.Event;

public class EventPrice {
    private final int eventPrice;

    private EventPrice(int eventPrice){
        this.eventPrice = eventPrice;
    }

    public static EventPrice from(int eventPrice) {
        return new EventPrice(eventPrice);
    }
}
