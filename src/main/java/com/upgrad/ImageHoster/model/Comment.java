package com.upgrad.ImageHoster.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {
    // These annotations auto-increments the id column for us whenever
    // a new Comment object is stored into the database
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Image image;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Comment() { }

    public Comment(String text) {
        this.text = text;
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Image getImage() {
        return image;
    }

}
