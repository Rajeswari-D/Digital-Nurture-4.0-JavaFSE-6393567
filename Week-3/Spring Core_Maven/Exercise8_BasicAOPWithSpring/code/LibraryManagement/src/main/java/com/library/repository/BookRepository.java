package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String getBook() {
        return "Spring in Action";
    }
}
