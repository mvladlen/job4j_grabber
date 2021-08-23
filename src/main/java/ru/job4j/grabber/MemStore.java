package ru.job4j.grabber;

import ru.job4j.grabber.utils.Post;

import java.util.*;

public class MemStore implements Store {
    ArrayList<Post> posts =  new ArrayList<>();

    @Override
    public void save(Post post) {
        posts.add(post.getId(), post);
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post findById(String id) {
        return posts.get(Integer.parseInt(id));
    }
}
