package com.library.service;

import com.library.repository.BookRepo;

public class BookService {
    private BookRepo bookRepo;

    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(String bookName) {
        bookRepo.saveBook(bookName);
    }
}
