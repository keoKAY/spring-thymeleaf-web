package com.istad.springthymleafpartone.service.serviceImpl;

import com.istad.springthymleafpartone.model.Author;
import com.istad.springthymleafpartone.repository.AuthorRepository;
import com.istad.springthymleafpartone.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    // authorRepository
    private AuthorRepository authorRepository;

    AuthorServiceImpl(){
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthor();
    }
}
