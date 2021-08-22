package ru.job4j.grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SqlRuParse implements Parse {
    private final DateTimeParser dateTimeParser;
    private final List<Post> posts = new LinkedList<>();

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override

    public List<Post> list(String link) {
        Document doc;
        List<Post> posts = new LinkedList<>();
        DateTimeParser timeParser = new SqlRuDateTimeParser();
        try {
            doc = Jsoup.connect(link).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element href = td.child(0);
                Post post = detail(href.attr("href"));
                posts.add(post);
            }
        } catch (IOException e) {
            System.out.println("can't open page");
        }
        return posts;
    }

    @Override
    public Post detail(String link) {
        Document doc;
        Post post = null;
        try {
            doc = Jsoup.connect(link).get();
            Elements headers = doc.select(".messageHeader"); // title
            Elements dates = doc.select(".msgFooter"); // created
            Elements messages = doc.select(".msgBody"); // description
            headers.first();
            post = new Post(headers.first().text(),
                    link,
                    messages.next().text(),
                    dateTimeParser.parse(dates.first().text())
            );
        } catch (IOException e) {
            System.out.println("can't open page");
        }
        return post;
    }

    public static void main(String[] args) {
        Parse parse = new SqlRuParse(new SqlRuDateTimeParser());
        List<Post> posts = parse.list("https://www.sql.ru/forum/job-offers/");
        System.out.println(posts);

        Post post = parse.detail("https://www.sql.ru/forum/1338054/vakansiya-bi-analitik-razrabotchik");
        System.out.println(post);
    }
}
