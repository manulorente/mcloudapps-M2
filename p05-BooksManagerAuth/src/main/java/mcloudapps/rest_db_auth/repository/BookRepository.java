package mcloudapps.rest_db_auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.rest_db_auth.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    Page<Book> findAll(Pageable pageable);
}
