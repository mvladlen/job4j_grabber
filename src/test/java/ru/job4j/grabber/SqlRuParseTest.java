package ru.job4j.grabber;

import org.junit.Test;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.util.List;

public class SqlRuParseTest {
    @Test
    public void list() {
        Parse parse = new SqlRuParse(new SqlRuDateTimeParser());
        List<Post> posts = parse.list("https://www.sql.ru/forum/job-offers/");
        System.out.println(posts);

    }

    @Test
    public void whenDetail() {
        Parse parse = new SqlRuParse(new SqlRuDateTimeParser());
        Post post = parse.detail("https://www.sql.ru/forum/1338054/vakansiya-bi-analitik-razrabotchik");
        System.out.println(post);

    }
}