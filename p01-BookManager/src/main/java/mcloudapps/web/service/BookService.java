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

    private AtomicLong nextBookId = new AtomicLong();
    private AtomicLong nextCommentId = new AtomicLong();
    private final ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();

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

    public void addComment(Long bookId, Comment comment) {
        Long id = this.nextCommentId.getAndIncrement();
        comment.setId(id);
        this.books.get(bookId).getCommentsMap().put(id, comment);
    }

    public void deleteComment(Long bookId, Long commentId) {
        this.books.get(bookId).getCommentsMap().remove(commentId);
    }
    
}
