package ru.job4j.grabber.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SqlRuDateTimeParserTest {

    @Test
    public void whenDateTime ()
    {
        String date = "12 авг 21, 12:34";
        SqlRuDateTimeParser parser = new SqlRuDateTimeParser();
        LocalDateTime dateTime = parser.parse(date);
        assertEquals(dateTime.toString(),"2021-08-12T12:34");
    }
    @Test
    public void whenDateToday ()
    {
        String date = "сегодня, 12:34";
        SqlRuDateTimeParser parser = new SqlRuDateTimeParser();
        LocalDateTime dateTime = parser.parse(date);
        assertNotNull(dateTime);
    }

    @Test
    public void whenDateYesterday ()
    {
        String date = "вчера, 12:34";
        SqlRuDateTimeParser parser = new SqlRuDateTimeParser();
        LocalDateTime dateTime = parser.parse(date);
        assertNotNull(dateTime);
    }


}