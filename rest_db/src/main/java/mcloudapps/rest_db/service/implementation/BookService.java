package mcloudapps.rest_db.service.implementation;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mcloudapps.rest_db.model.Book;
import mcloudapps.rest_db.model.Comment;
import mcloudapps.rest_db.repository.implementation.BookRepository;
import mcloudapps.rest_db.repository.implementation.CommentRepository;

@Service
public class BookService implements mcloudapps.rest_db.service.BookService {

    private Mapper mapper;
    private BookRepository bookRepository;
    private CommentRepository commentRepository;

    public BookService(Mapper mapper, BookRepository bookRepository, CommentRepository commentRepository) {
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }
    
    public Collection<Book> findAll() {
        return this.bookRepository.findAll().stream().map(book -> this.mapper.map(book, Book.class)).collect(Collectors.toList());
    }

    public Book findById(long id) {
        Book book = this.mapper.map(this.bookRepository.findById(id).orElse(null), Book.class);
        book.setComments(this.commentRepository.findByBookId(id));
        return this.mapper.map(book, Book.class);
    }

    public Book deleteById(long id) {
        Book book = this.mapper.map(this.bookRepository.findById(id).orElse(null), Book.class);
        return this.bookRepository.deleteById(id);

    }

    public Book save(Book book) {
        return this.mapper.map(this.bookRepository.save(this.mapper.map(book, Book.class)), Book.class);
    }

    public Collection<Comment> getComments(long bookId) {
        return this.commentRepository.findByBookId(bookId);
    }
    public Comment addComment(long bookId, Comment comment) {
        Comment commentEntity = this.mapper.map(comment, Comment.class);
        commentEntity.setBookId(bookId);
        return this.mapper.map(this.commentRepository.save(commentEntity), Comment.class);
    }

    public Comment deleteComment(long bookId, long commentId){
        Book book = this.mapper.map(this.bookRepository.findById(bookId).orElse(null), Book.class);
        Comment commentEntity = this.mapper.map(this.commentRepository.findByBookId(bookId, commentId), Comment.class);
        return this.mapper.map(this.commentRepository.delete(commentEntity), Comment.class);
    }
}
