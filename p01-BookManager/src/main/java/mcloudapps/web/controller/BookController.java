package mcloudapps.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mcloudapps.web.model.Book;
import mcloudapps.web.model.Comment;
import mcloudapps.web.service.BookService;
import mcloudapps.web.service.UserSession;

@Controller
public class BookController {
    
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
	private BookService bookService;    

    @Autowired
    private UserSession userSession;

    @GetMapping("/")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @GetMapping("/book/{bookId}")
    public String showBook(Model model, @PathVariable("bookId") Long bookId) {
        model.addAttribute("book", bookService.findById(bookId));
        model.addAttribute("userName", userSession.getUserName());
        log.info("showBook: " + bookId + " - " + userSession.getUserName());
        return "show_book";
    }

    @PostMapping("/create")
    public String createBook(Model model, Book book) {
        log.info("Creating book: {}", book);
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/{bookId}/delete")
    public String deleteBook(Model model, @PathVariable("bookId") Long bookId) {
        log.info("Deleting book: {}", bookId);
        bookService.deleteById(bookId);
        return "redirect:/";
    }

    @PostMapping("/book/{bookId}/comment/new")
    public String createComment(Model model, Comment comment, @PathVariable("bookId") Long bookId) {
        userSession.setUserName(comment.getUserName());
        bookService.addComment(bookId, comment);
        log.info("User {} creating comment: {}", comment.getUserName(), comment);        
        return "redirect:/book/" + bookId;
    }

    @GetMapping("/book/{bookId}/comments/{commentId}/delete")
    public String deleteComment(Model model, @PathVariable("bookId") Long bookId, @PathVariable("commentId") Long commentId) {
        log.info("Deleting comment: {} for book: {}", commentId, bookId);
        bookService.deleteComment(bookId, commentId);
        return "redirect:/book/" + bookId;
    }

}
