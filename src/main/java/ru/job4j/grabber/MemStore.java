package ru.job4j.grabber;

import ru.job4j.grabber.utils.Post;

import java.util.LinkedHashMap;
import java.util.List;

public class MemStore implements Store {
    List<Post> posts = (List<Post>) new LinkedHashMap<Integer, Post>();

    @Override
    public void save(Post post) {
        posts.add(post.getId(), post);
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts.get(id);
    }
}
