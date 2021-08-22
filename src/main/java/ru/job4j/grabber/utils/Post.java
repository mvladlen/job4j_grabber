package ru.job4j.grabber.utils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private static int counter = 0;
    private int id; // типа int - идентификатор вакансии (берется из нашей базы данных);
    private String title; // типа String - название вакансии;
    private String link; // типа String - ссылка на описание вакансии;
    private String description; // типа String - описание вакансии;
    private LocalDateTime created; // типа LocalDateTime - дата создания вакансии.

    public Post() {
        new Post(counter++, "title", "link", "description", LocalDateTime.now());
    }

    public Post(int id, String title, String link, String description) {
        new Post(id, title, link, description, LocalDateTime.now());
    }

    public Post(int id, String title, String link, String description, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(link, post.link) &&
                Objects.equals(description, post.description) &&
                Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, link, description, created);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                '}';
    }
}
