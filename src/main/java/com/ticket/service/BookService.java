package com.ticket.service;

import com.ticket.entity.Book;
import com.ticket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book addTicket(Book book) {
        Book store = new Book();
        store.setFirstName(book.getFirstName());
        store.setLastName(book.getLastName());
        store.setEmail(book.getEmail());
        store.setPhone(book.getPhone());
        store.setAddress(book.getAddress());
        store.setCity(book.getCity());
        Book savedTicket = bookRepository.save(store);
        return savedTicket;
    }
}
