package mcloudapps.rest_db_auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.rest_db_auth.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    Page<Comment> findAll(Pageable pageable);
}
