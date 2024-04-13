package com.ticket.controller;

import com.ticket.entity.Book;
import com.ticket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@CrossOrigin("http://localhost:4200/")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addTicket(@RequestBody Book book) {
        Book book1 = bookService.addTicket(book);
        return book1;
    }
}
