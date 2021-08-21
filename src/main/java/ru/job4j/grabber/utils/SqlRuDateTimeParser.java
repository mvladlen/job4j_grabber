package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static java.util.Map.entry;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS = Map.ofEntries(
            entry("янв", "1"),
            entry("фев", "2"),
            entry("мар", "3"),
            entry("апр", "4"),
            entry("май", "5"),
            entry("июн", "6"),
            entry("июл", "7"),
            entry("авг", "8"),
            entry("сен", "9"),
            entry("окт", "10"),
            entry("ноя", "11"),
            entry("дек", "12")
    );

    @Override
    public LocalDateTime parse(String parse) {

        String[] strings = parse.split("[\\s,:]");
        if (strings.length < 6)
            if (strings[0].equals("сегодня")) {
                return LocalDateTime.of(
                        LocalDate.now().getYear(),
                        LocalDate.now().getMonth(),
                        LocalDate.now().getDayOfMonth(),
                        Integer.parseInt(strings[2]),
                        Integer.parseInt(strings[3]));

            } else if (strings[0].equals("вчера")) {
                return LocalDateTime.of(
                        LocalDate.now().getYear(),
                        LocalDate.now().getMonth(),
                        LocalDate.now().getDayOfMonth(),
                        Integer.parseInt(strings[2]),
                        Integer.parseInt(strings[3])).minusDays(1);

            }
        return LocalDateTime.of(
                2000+Integer.parseInt(strings[2]),
                Integer.parseInt(MONTHS.get(strings[1])),
                Integer.parseInt(strings[0]),
                Integer.parseInt(strings[4]),
                Integer.parseInt(strings[5])
        );

    }
}