package mcloudapps.web.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import mcloudapps.web.model.Book;
import mcloudapps.web.model.Comment;


@Service
public class BookService {

    private static AtomicLong nextBookId = new AtomicLong();
    private static AtomicLong nextCommentId = new AtomicLong();
    private final ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();

    public BookService(){
        this.save(new Book("The Lord of the Rings", 
        "The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels ever written, with over 150 million copies sold.", 
        "J. R. R. Tolkien", 
        "Allen & Unwin", 
        "1954-07-29"));
        this.save(new Book("The Hobbit",
        "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction. The book remains popular and is recognized as a classic in children's literature.",
        "J. R. R. Tolkien", 
        "Allen & Unwin",
        "1937-09-21"));
        this.save(new Book("Spring Framework",
        "The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform.",
        "Rod Johnson",
        "Spring",
        "2003"));
        this.save(new Book("Spring Cloud",
        "Spring Cloud is a framework for building cloud-native applications. It provides tools for developers to quickly build some of the common patterns in distributed systems.",
        "Josh Long",
        "Spring",
        "2013"));
    }

    public Collection<Book> findAll() {
        return this.books.values();
    }

    public Book findById(long id) {
        return this.books.get(id);
    }

    public void save(Book book) {
        Long id = book.getId();
        assert id == null;
        id = nextBookId.getAndIncrement();
        book.setId(id);
        this.books.put(id, book);
    }

    public void deleteById(Long id) {
        this.books.remove(id);
    }

    public void addComment(Long bookId, String text, String user, Long rating) {
        Book book = this.books.get(bookId);
        book.addComent(new Comment(nextCommentId.getAndIncrement(), bookId, text, user, rating));
    }

    public void deleteComment(Long bookId, Long commentId) {
        Book book = this.books.get(bookId);
        book.getComments().removeIf(comment -> comment.getId().equals(commentId));
    }
    
}
