package christmas.domain.progress;

public enum DateType {
    D_DAY("크라스마스 디데이"), WEEKDAY("평일"), WEEKEND("주말"), SPECITAL("특별");
    private String type;

    DateType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
