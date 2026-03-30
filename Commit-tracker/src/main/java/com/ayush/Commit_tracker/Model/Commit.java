package com.ayush.Commit_tracker.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Commit {

    @Id
    @GeneratedValue
    private Long id;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
}
