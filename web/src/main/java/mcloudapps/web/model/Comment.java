package mcloudapps.web.model;

public class Comment {

    private Long id;
    private Long bookId;
    private String text;
    private String userName;
    private Long rating;

    public Comment() {
    }

    public Comment(Long id ,Long bookId, String text, String userName, Long rating) {
        super();
        this.id = id;
        this.bookId = bookId;
        this.text = text;
        this.userName = userName;
        this.rating = rating;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment [bookId=" + bookId + ", id=" + id + ", rating=" + rating + ", text=" + text + ", userName=" + userName
                + "]";
    }

}
