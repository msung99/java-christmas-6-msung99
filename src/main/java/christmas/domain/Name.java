package christmas.domain;

public class Name {
    private final String name;

    private Name(String name){
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }
}
