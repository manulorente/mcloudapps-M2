package mcloudapps.rest_db.service;

import mcloudapps.rest_db.dto.BookDTO;
import mcloudapps.rest_db.dto.BookCreateDTO;
import mcloudapps.rest_db.mapper.BookMapper;
import mcloudapps.rest_db.model.Book;
import mcloudapps.rest_db.repository.BookRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookDTO save(BookCreateDTO bookCreateDTO) {
        return bookMapper.toDTO(bookRepository.save(bookMapper.toDomain(bookCreateDTO)));
    }

    public Page<BookDTO> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toDTO);
    }

    public BookDTO findByIdDTO(long id) {
        return bookMapper.toDTO(bookRepository.findById(id).orElseThrow());
    }

    public Book findById(long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public BookDTO replace(BookCreateDTO bookDTO, long id) {
        Book newBook = bookMapper.toDomain(bookDTO);
        newBook.setId(id);
        Book oldBook = bookRepository.findById(newBook.getId()).orElseThrow();
        oldBook.getComments().forEach(review -> newBook.getComments().add(review));
        bookRepository.save(newBook);
        return bookMapper.toDTO(newBook);
    }

    public BookDTO delete(long id) {
        Book book = findById(id);
        bookRepository.deleteById(id);
        return bookMapper.toDTO(book);
    }

}