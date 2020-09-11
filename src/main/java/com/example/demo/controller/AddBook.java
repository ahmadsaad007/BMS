package com.example.demo.controller;

import com.example.demo.dao.BookDao;
import com.example.demo.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
//
//
//public class AddBook {
//
//    @RequestMapping("/add/{author}")
//    public String addBook(@RequestParam("author") String author, @RequestParam("isbn") int isbn, Model model, @ModelAttribute("newBook") Book book){
//        Book prev= (Book) model.getAttribute("book");
//        System.out.println("Prev page book: "+ prev.getName());
//        System.out.println("Author: "+author + " ISBN: "+isbn);
//        Book b= new Book(book.getName(), author,isbn, book.getDate());
//        boolean result = BookDao.addBook(b);
//        return "home";
//    }
//}
