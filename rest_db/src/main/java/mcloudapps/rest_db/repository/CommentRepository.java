package mcloudapps.rest_db.repository;

import java.util.Collection;

import mcloudapps.rest_db.model.Comment;

public interface CommentRepository {
    
    Collection<Comment> findByBookId(long bookId);

    Comment findById(long id);
    
    Comment save(Comment comment);

    Comment deleteById(long id);


}
