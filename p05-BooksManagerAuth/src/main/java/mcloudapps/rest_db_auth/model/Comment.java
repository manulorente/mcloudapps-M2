package mcloudapps.rest_db_auth.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private int rating;
    @ManyToOne(cascade = CascadeType.ALL)
    private User username;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Comment() {
    }

    public Comment(String text, int rating, User username, Book book) {
        this.text = text;
        this.rating = rating;
        this.username = username;
        this.book = book;
    }

    public Long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public int getRating() {
        return this.rating;
    }

    public User getUsername() {
        return this.username;
    }

    public Book getBook() {
        return this.book;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", username=" + username +
                ", book=" + book +
                '}';
    }

}
