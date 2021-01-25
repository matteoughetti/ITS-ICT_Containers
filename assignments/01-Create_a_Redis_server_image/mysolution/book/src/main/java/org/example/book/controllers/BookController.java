package org.example.book.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.book.models.Book;
import org.example.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/v2/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.PUT)
    public void setBook(@RequestBody Book book){
        bookRepository.save(book);
        System.out.println(book);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        log.info("Get all book");
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable long bookId){
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if(bookOpt.isPresent()){
            log.info("Get book by id");
            return bookOpt.get();
        }else{
            log.warn("Book not found");
            return null;
        }
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.POST)
    public Book editBook(@RequestBody Book book, @PathVariable long bookId){
        log.info("book saved");
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable long bookId){

        bookRepository.deleteById(bookId);
        log.info("Book deleted");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBook() {

        bookRepository.deleteAll();
        log.info("deleted all book");
    }

}