package com.test.demo.controller;

import com.test.demo.entity.Author;
import com.test.demo.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors/create",method = RequestMethod.POST)
    @ResponseBody
    public String createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return "Author created successfully";
    }


    @RequestMapping("/authors")
    @ResponseBody
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors ();
    }

    @RequestMapping("/authors/{id}")
    @ResponseBody
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.findAuthorById (id);
    }

    @RequestMapping(value = "/authors/update", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
        return "Author updated successfully";
    }

    @RequestMapping(value = "/authors/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return "Author deleted successfully";
    }
}
