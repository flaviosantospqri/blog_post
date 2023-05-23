package com.blog.blog_post.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID= 1L;

    private String id;
    private String text;
    private Instant date;

    private Post post;

    public Comment() {
    }

    public Comment(String id, String text, Instant date, Post post) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;

        return getDate() != null ? getDate().equals(comment.getDate()) : comment.getDate() == null;
    }

    @Override
    public int hashCode() {
        return getDate() != null ? getDate().hashCode() : 0;
    }
}
