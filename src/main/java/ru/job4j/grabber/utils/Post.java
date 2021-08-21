package ru.job4j.grabber.utils;

import java.time.LocalDateTime;

public class Post {
    int id; // типа int - идентификатор вакансии (берется из нашей базы данных);
    String title; // типа String - название вакансии;
    String link; // типа String - ссылка на описание вакансии;
    String description; // типа String - описание вакансии;
    LocalDateTime created; // типа LocalDateTime - дата создания вакансии.

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
