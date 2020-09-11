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
        model.put("newBook", new Book());
        model.put("updateBook", new Book());
        model.put("addBook",new Book());
        return "home";
    }

    @PostMapping("/get")
    public String change(@RequestParam("author") String author, Model model,
                         @ModelAttribute("newBook")Book book) {
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
    public String addBook(@RequestParam("author") String author, @RequestParam("isbn") int isbn, Model model,
                          @ModelAttribute("addBook") Book book){
        System.out.println("Author: "+author + " ISBN: "+isbn);
        model.addAttribute("addBook", new Book());
        Book b= new Book(book.getName(), author,isbn, book.getDate());
        model.addAttribute("add", book);
        boolean result = BookDao.addBook(b);
        if(result)
            return "home";
        else
            return "error";
    }
    @RequestMapping("/update")
    public String updateBook(@RequestParam("author") String author, @RequestParam("isbn") int isbn, Model model,
                             @ModelAttribute("updateBook") Book book){
        System.out.println("Author: "+author + " ISBN: "+isbn);
        Book b= new Book(book.getName(), author,isbn, book.getDate());
        model.addAttribute("updateBook", new Book());
        model.addAttribute("update",b);
        BookDao.updateBook(isbn, b);
        return "home";
    }
}
