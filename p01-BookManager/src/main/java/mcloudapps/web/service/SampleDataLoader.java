package mcloudapps.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import mcloudapps.web.model.Book;

@Component
public class SampleDataLoader {

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void loadData() {
        bookService.save(new Book("The Lord of the Rings", 
        "The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels ever written, with over 150 million copies sold.", 
        "J. R. R. Tolkien", 
        "Allen & Unwin", 
        "1954-07-29"));
        bookService.save(new Book("The Hobbit",
        "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction. The book remains popular and is recognized as a classic in children's literature.",
        "J. R. R. Tolkien", 
        "Allen & Unwin",
        "1937-09-21"));
        bookService.save(new Book("Spring Framework",
        "The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform.",
        "Rod Johnson",
        "Spring",
        "2003"));
        bookService.save(new Book("Spring Cloud",
        "Spring Cloud is a framework for building cloud-native applications. It provides tools for developers to quickly build some of the common patterns in distributed systems.",
        "Josh Long",
        "Spring",
        "2013"));
    }

    
}
