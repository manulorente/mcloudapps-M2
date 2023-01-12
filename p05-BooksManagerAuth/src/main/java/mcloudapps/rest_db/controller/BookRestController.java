package mcloudapps.rest_db.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.net.URI;

import jakarta.validation.Valid;

import mcloudapps.rest_db.dto.BookDTO;
import mcloudapps.rest_db.dto.BookCreateDTO;
import mcloudapps.rest_db.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BookRestController {
    
    private BookService bookService;  
    
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get all books")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get all books", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookDTO.class))) }) })
    @GetMapping("/")
    public ResponseEntity<Page<?>> getBooks(Pageable pageable) {
        return ResponseEntity.ok(this.bookService.findAll(pageable));
    }
    @Operation(summary = "Get a book by the id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get a book by id", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.findByIdDTO(id));
    }

    @Operation(summary = "Create a new book")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created the book", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid book attributes supplied", content = @Content) })
    @PostMapping("/")
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookCreateDTO newBook) {
        BookDTO bookDTO = this.bookService.save(newBook);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookDTO.id()).toUri();
        return ResponseEntity.created(location).body(bookDTO);
        }

    @Operation(summary = "Update a book")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated the book", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid book attributes supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookCreateDTO newBook, @PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.replace(newBook, id));
    }

    @Operation(summary = "Delete a book")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Deleted the book", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.delete(id));
    }
}
