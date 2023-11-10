package christmas.domain;

public class Count {
    private int count;

    private Count(int count){
        this.count = count;
    }

    public static Count of(int count){
        return new Count(count);
    }
}
