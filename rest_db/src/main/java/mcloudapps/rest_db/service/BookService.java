package mcloudapps.rest_db.service;

import java.util.Collection;
import java.util.List;

import mcloudapps.rest_db.model.Book;
import mcloudapps.rest_db.model.Comment;

public interface BookService {

    Collection<Book> findAll();

    Book findById(long id);

    Book deleteById(long id);

    Book save(Book book);

    Collection<Comment> getComments(long bookId);

    Comment addComment(long bookId, Comment comment);

    Comment deleteComment(long bookId, long commentId);
    
}
