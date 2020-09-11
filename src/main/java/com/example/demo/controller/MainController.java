package com.example.demo.controller;

import com.example.demo.dao.BookDao;
import com.example.demo.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        //Long isbn = Long.valueOf(1234567890);
        //model.put("book", Book.builder().name("How to not worry about Assignments in BFS Training!").author("Zack Yu").date("09/10/2020").isbn(isbn).build());
        model.put("newBook", new Book());

        return "home";
    }

    @PostMapping("/get")
    public String change(@RequestParam("author") String author, Model model, @ModelAttribute("newBook")Book book) {
        System.out.println(author);
        Book b = BookDao.getBook(book.getAuthor(), book.getDate());
        if(b == null){
            return "home";
        }
        model.addAttribute("book", b);
        model.addAttribute("newBook", new Book());
        return "home";
    }
    @RequestMapping("/add")
    public String addBook(@RequestParam("author") String author, @RequestParam("isbn") int isbn, Model model, @ModelAttribute("book") Book book){
        System.out.println("Author: "+author + " ISBN: "+isbn);
        //model.getAttribute("name")
        Book b= new Book(book.getName(), author,isbn, book.getDate());
        boolean result = BookDao.addBook(b);
        if(result)
            return "home";
        else
            return "error";
    }
    @RequestMapping("/update")
    public String updateBook(@RequestParam("author") String author, @RequestParam("isbn") int isbn, Model model, @ModelAttribute("newBook") Book book){
        System.out.println("Author: "+author + " ISBN: "+isbn);
        Book b= new Book(book.getName(), author,isbn, book.getDate());
        BookDao.updateBook(isbn, b);
        return "home";
    }
}
