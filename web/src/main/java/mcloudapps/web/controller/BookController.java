package mcloudapps.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mcloudapps.web.model.Book;
import mcloudapps.web.service.BookService;

@Controller
public class BookController {
    
    @Autowired
	private BookService bookService;    

    @GetMapping("/")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @PostMapping("/create")
    public String createBook(Model model, Book book) {
        bookService.save(book);
        return "saved_book";
    }

    @GetMapping("/book/{bookId}")
    public String showBook(Model model, @PathVariable("bookId") Long bookId) {
        model.addAttribute("book", bookService.findById(bookId));
        return "show_book";
    }

    @GetMapping("/book/{bookId}/delete")
    public String deleteBook(Model model, @PathVariable("bookId") Long bookId) {
        bookService.deleteById(bookId);
        return "deleted_book";
    }

    @PostMapping("/book/{bookId}/comments")
    public String createComment(Model model, @PathVariable("bookId") Long bookId, String text, String user, Long rating) {
        bookService.addComment(bookId, text, user, rating);
        return "saved_comment";
    }

    @GetMapping("/book/{bookId}/comments/{commentId}/delete")
    public String deleteComment(Model model, @PathVariable("bookId") Long bookId, @PathVariable("commentId") Long commentId) {
        bookService.deleteComment(bookId, commentId);
        return "deleted_comment";
    }

}
