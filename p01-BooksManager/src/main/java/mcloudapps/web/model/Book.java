package mcloudapps.web.model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Book {

    private Long id;
    private String title;
    private String summary;
    private String author;
    private String publisher;
    private String date;
	private ConcurrentMap<Long, Comment> comments = new ConcurrentHashMap<>();

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

	public Map<Long, Comment> getCommentsMap() {
		return this.comments;
	}
	
	public Collection<Comment> getComments() {
		return this.comments.values();
	}

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", summary=" + summary + ", author=" + author + ", publisher="
                + publisher + ", date=" + date + "]";
    }

}
