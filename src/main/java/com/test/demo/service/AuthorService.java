package com.test.demo.service;

import com.test.demo.entity.Author;
import com.test.demo.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




import java.util.List;

public interface AuthorService {
    public List<Author> findAllAuthors();
    public Author findAuthorById(Long id);
    public void createAuthor(Author author);
    public  void updateAuthor(Author author);
    public  void deleteAuthor(Long id);




}
