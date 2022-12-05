package mcloudapps.rest_db.repository;

public interface BookRepository {
    
    Collection<Book> findAll();

    Book save(Book book);

    Collection<Book> findById(long id);
}
