package mcloudapps.rest_db.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String summary;
    private String author;
    private String publisher;
    private String date;
    
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String summary, String author, String publisher, String date) {
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
        this.comments = new ArrayList<>();
    } 

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getDate() {
        return this.date;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", date='" + date + '\'' +
                ", comments=" + comments +
                '}';
    }

}
