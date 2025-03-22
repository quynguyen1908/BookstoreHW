package com.ejbproject.bookstore.service;

import com.ejbproject.bookstore.model.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class BookService {

    @PersistenceContext(unitName = "BookStorePU")
    private EntityManager em;

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    public Book getBookById(int id) {
        return em.find(Book.class, id);
    }
}
