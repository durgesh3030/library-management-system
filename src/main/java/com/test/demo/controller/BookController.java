package com.test.demo.controller;

import com.test.demo.entity.Book;
import com.test.demo.service.AuthorService;
import com.test.demo.service.BookService;
import com.test.demo.service.CategoryService;
import com.test.demo.service.PublisherService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class BookController {
    private  final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;


    public BookController ( BookService bookService, AuthorService authorService, CategoryService categoryService, PublisherService publisherService ) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
    }

    @RequestMapping({"/books", "/"})
    @ResponseBody
    public List<Book> getAllBook(){
        return bookService.findAllBooks ();
    }
    @RequestMapping("/book/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable("id") Long id ){
        return bookService.findBookById (id);
    }
    @RequestMapping("/searchbook")
    @ResponseBody
    public List<Book> searchBook( @Param("keyword") String keyword, Model model) {

        model.addAttribute("books", bookService.searchBooks(keyword));
        model.addAttribute("keyword", keyword);

        return bookService.searchBooks (keyword);
    }
   @GetMapping("/add")
   @ResponseBody
    public String showCreateForm(  Book book, Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "add-book";
    }
    @RequestMapping(value = "/addbook",method = RequestMethod.POST)
    @ResponseBody
    public String createBook(@RequestBody Book book){
        bookService.createBook (book);
        return "book Added";
    }
    @RequestMapping(value = "/book/update",method = RequestMethod.PUT)
    @ResponseBody
    public String updateBook(@RequestBody Book book){
        bookService.updateBook (book);
        return "Book updated successfully";
    }
    @RequestMapping(value = "/book/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook (id);
        return "Book Delete successfully";
    }

}



