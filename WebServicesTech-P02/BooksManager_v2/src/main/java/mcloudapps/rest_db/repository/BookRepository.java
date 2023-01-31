package mcloudapps.rest_db.repository;

import org.springframework.data.domain.Page;

import mcloudapps.rest_db.model.Book;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    Page<Book> findAll(Pageable pageable);
}
