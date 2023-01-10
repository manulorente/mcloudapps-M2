package mcloudapps.rest_db.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private int rating;
    @ManyToOne
    private User userName;
    @ManyToOne
    private Book book;

    public Comment() {
    }

    public Comment(String text, int rating, User userName, Book book) {
        this.text = text;
        this.rating = rating;
        this.userName = userName;
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

    public User getUserName() {
        return this.userName;
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

    public void setUserName(User userName) {
        this.userName = userName;
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
                ", userName=" + userName +
                ", book=" + book +
                '}';
    }

}
