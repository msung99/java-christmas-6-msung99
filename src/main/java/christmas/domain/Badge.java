package christmas.domain;

import java.util.Arrays;

public enum Badge {
    NOTHING("없음", 0, 0),
    STAR("뱔", 5000, 9999),
    TREE("트리", 10000, 19999),
    SANTA("산타", 20000, 99999999);

    private String name;
    private int min;
    private int max;

    Badge(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public static Badge findByValue(int discountPrice) {
        return Arrays.stream(values())
                .filter(badge -> discountPrice >= badge.min && discountPrice <= badge.max)
                .findFirst()
                .orElse(NOTHING);
    }

    @Override
    public String toString() {
        return this.name;
    }
}