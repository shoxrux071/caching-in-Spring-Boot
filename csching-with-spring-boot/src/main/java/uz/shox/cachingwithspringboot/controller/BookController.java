package uz.shox.cachingwithspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.shox.cachingwithspringboot.domains.Book;
import uz.shox.cachingwithspringboot.dtos.BookUpdateDto;
import uz.shox.cachingwithspringboot.service.BookService;

import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 18/11/22 18:33 (Friday)
 * caching-in-Spring-Boot/IntelliJ IDEA
 */
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getOne(@PathVariable String id) {
        return bookService.getOne(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book update(@RequestBody BookUpdateDto dto) {
        return bookService.update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        bookService.delete(id);
    }

}
