package christmas.repository;

import christmas.domain.progress.Date;
import christmas.domain.progress.DateType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateRepository {
    private final Map<DateType, List<Date>> dates = new HashMap<>();
    private static final DateRepository dateRepository = null;

    private DateRepository(){
        dates.put(DateType.D_DAY, initDDay());
        dates.put(DateType.WEEKDAY, initWeekDay());
        dates.put(DateType.WEEKEND, initWeekEnd());
        dates.put(DateType.SPECITAL, initSpecial());
    }

    public static DateRepository getInstance() {
        if(dateRepository == null) {
            return new DateRepository();
        }
        return dateRepository;
    }

    public List<Date> getDatesByType(DateType dateType) {
        return dates.entrySet().stream()
                .filter(entry -> entry.getKey() == dateType)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow();
    }


    private List<Date> initDDay() {
        return IntStream.rangeClosed(1, 25)
                .mapToObj(i -> Date.of(String.valueOf(i)))
                .collect(Collectors.toList());
    }

    private List<Date> initWeekDay(){
        List<Integer> targetDays = List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31);

        return targetDays.stream()
                .map(day -> Date.of(String.valueOf(day)))
                .collect(Collectors.toList());
    }

    private List<Date> initWeekEnd(){
        List<Integer> targetDays = List.of(1,2,8,9,15,16,22,23,29,30);

        return targetDays.stream()
                .map(day -> Date.of(String.valueOf(day)))
                .collect(Collectors.toList());
    }

    private List<Date> initSpecial(){
        List<Integer> targetDays = List.of(3,10,17,24,25,31);

        return targetDays.stream()
                .map(day -> Date.of(String.valueOf(day)))
                .collect(Collectors.toList());
    }
}
