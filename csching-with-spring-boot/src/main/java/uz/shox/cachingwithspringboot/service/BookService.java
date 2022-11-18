package uz.shox.cachingwithspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.shox.cachingwithspringboot.domains.Book;
import uz.shox.cachingwithspringboot.dtos.BookUpdateDto;
import uz.shox.cachingwithspringboot.repos.BookRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 18/11/22 18:23 (Friday)
 * caching-in-Spring-Boot/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Cacheable(cacheNames = "book",key = "#id")
    @SneakyThrows
    public Book getOne(String id)  {
        TimeUnit.SECONDS.sleep(2);
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
    }
    @CacheEvict(cacheNames = "book",key = "#id")
    public void delete(String id){
        bookRepository.deleteById(id);
    }
    @CachePut(cacheNames = "book",key = "#dto.id")
    public Book update(BookUpdateDto dto){
        Book book = getOne(dto.getId());
        if (dto.getName() != null)
            book.setName(dto.getName());
        if (dto.getAuthor() != null)
            book.setAuthor(dto.getAuthor());
        if (dto.getGenre() != null)
            book.setGenre(dto.getGenre());
        return bookRepository.save(book);
    }

    public void create(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
