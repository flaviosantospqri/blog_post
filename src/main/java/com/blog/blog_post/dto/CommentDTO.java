package com.blog.blog_post.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    private String text;
    private Instant date;
    private AuthorDTO authorDTO;

    public CommentDTO() {
    }

    public CommentDTO(String text, Instant date, AuthorDTO authorDTO) {
        this.text = text;
        this.date = date;
        this.authorDTO = authorDTO;
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

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
