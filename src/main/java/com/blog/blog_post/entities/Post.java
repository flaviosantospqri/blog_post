package com.blog.blog_post.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private Instant date;
    private String title;
    private String body;

    private User user;
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String id, Instant date, String title, String body, User user) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;

        if (getId() != null ? !getId().equals(post.getId()) : post.getId() != null) return false;
        return getDate() != null ? getDate().equals(post.getDate()) : post.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }
}
