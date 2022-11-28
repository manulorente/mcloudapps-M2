package mcloudapps.web.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Long id;
    private String title;
    private String summary;
    private String author;
    private String publisher;
    private String date;
    private List<Comment> comments = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String summary, String author, String publisher, String date) {
        super();
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addComent(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", summary=" + summary + ", author=" + author + ", publisher="
                + publisher + ", date=" + date + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!Book.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Book other = (Book) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
