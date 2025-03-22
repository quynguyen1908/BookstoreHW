package com.ejbproject.bookstore.servlet;

import com.ejbproject.bookstore.service.BookService;
import com.ejbproject.bookstore.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @EJB
    private BookService bookService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        Book book = bookService.getBookById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/views/order.jsp").forward(request, response);
    }
}