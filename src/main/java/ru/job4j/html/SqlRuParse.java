package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SqlRuParse {
    List<Post> posts = new LinkedList<>();
    int page = 0;

    public List<Post> SqlRuParsePages(int pages) {

        for (int i = 1; i <= pages; i++) {
            getNextPage();
        }
        return posts;
    }
    private List<String> getTopic(String link) {
        Document doc;
        List<String> messages = new LinkedList<>();
        try {
            doc = Jsoup.connect(link).get();
            Elements row = doc.select(".msgBody");
            for (Element td: row) {
                messages.add(td.ownText());
            }

        } catch (IOException e) {
            System.out.println("can't open page");
        }
        return messages;
    }
    private List<Post> getNextPage() {
        page++;
        Document doc;
        DateTimeParser timeParser = new SqlRuDateTimeParser();
        try {
            doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + page).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Post post = new Post();
                Element href = td.child(0);
                post.setLink(href.attr("href"));
                post.setTitle(href.text());
                post.setCreated(timeParser.parse(td.parent().children().get(5).text()));
                List<String> messages = getTopic(post.getLink());
                post.setDescription(messages.get(1));
                posts.add(post);
            }
        } catch (IOException e) {
            System.out.println("can't open page");
        }
        return posts;
    }

        public static void main(String[] args) {

        SqlRuParse parser = new SqlRuParse();
        for (int i = 1; i <= 5; i++) {
            List<Post> posts = parser.getNextPage();
            for (Post post : posts) {
                System.out.println(post.getTitle());
                System.out.println(post.getDescription());
                System.out.println(post.getLink());
                System.out.println(post.getCreated());
            }
        }
    }

}