package mcloudapps.rest_db.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import mcloudapps.rest_db.model.Book;
import mcloudapps.rest_db.model.Comment;
import mcloudapps.rest_db.service.implementation.BookService;

@RestController
@RequestMapping("/v1/api/books")
public class BookController {
    
    @Autowired
	private BookService bookService;    

    @Operation(summary = "Get all books")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get all books", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookService.class))) }) })
    @GetMapping("/")
    public Collection<Book> getBooks() {
        return this.bookService.findAll();
    }

    @Operation(summary = "Get a book by the id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get a book by id", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@Parameter(description = "Id of the book")
        @PathVariable Long bookId) {
        Book book = this.bookService.findById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @Operation(summary = "Create a new book")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Book to be created", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)))
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Created the book", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid book attributes supplied", content = @Content) })
    @PostMapping("/")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        this.bookService.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(location).body(book);
        }

    @Operation(summary = "Update a book")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Book to be updated", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)))
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated the book", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid book attributes supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@Parameter(description = "ID of the book to update") @PathVariable Long bookId,
    @Parameter(description = "Content to update") @RequestBody Book book) {
        Book bookToUpdate = this.bookService.findById(bookId);
        if (bookToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        bookToUpdate.setId(bookId);
        this.bookService.save(bookToUpdate);
        return ResponseEntity.ok(bookToUpdate);
    }

    @Operation(summary = "Delete a book")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Deleted the book", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteBook(@Parameter(description = "Id of the book")
        @PathVariable Long bookId) {
        Book book = this.bookService.findById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        this.bookService.deleteById(bookId);
        return ResponseEntity.ok(book);
    }

    @Operation(summary = "Add a comment to a book")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Comment to be added", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Comment.class)))
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Added the comment", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid comment attributes supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @PostMapping("/{bookId}/comments")
    public ResponseEntity<Comment> addComment(@Parameter(description = "Id of the book") @PathVariable Long bookId,
    @Parameter(description = "Comment to add") @RequestBody Comment newComment) {
        Comment comment = this.bookService.addComment(bookId, newComment);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comment);
    }

    @Operation(summary = "Get all comments of a book")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get all comments of a book", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Comment.class))) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @GetMapping("/{bookId}/comments")
    public ResponseEntity<Collection<Comment>> getComments(@Parameter(description = "Id of the book")
        @PathVariable Long bookId) {
        Collection<Comment> comments = this.bookService.getComments(bookId);
        if (comments == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "Delete a comment of a book")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Deleted the comment", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = BookService.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @DeleteMapping("/{bookId}/comments/{commentId}")
    public ResponseEntity<Comment> deleteComment(@Parameter(description = "Id of the book")
        @PathVariable Long bookId, @Parameter(description = "Id of the comment") @PathVariable Long commentId) {
        Comment comment = this.bookService.deleteComment(bookId, commentId);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comment);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
