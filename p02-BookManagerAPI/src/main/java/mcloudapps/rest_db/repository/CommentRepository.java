package mcloudapps.rest_db.repository;

import mcloudapps.rest_db.model.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    Page<Comment> findAll(Pageable pageable);
}
