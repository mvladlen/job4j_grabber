package ru.job4j.grabber.utils;

import java.time.LocalDateTime;

public class Post {
    int id; // типа int - идентификатор вакансии (берется из нашей базы данных);
    String title; // типа String - название вакансии;
    String link; // типа String - ссылка на описание вакансии;
    String description; // типа String - описание вакансии;
    LocalDateTime created; // типа LocalDateTime - дата создания вакансии.
}
