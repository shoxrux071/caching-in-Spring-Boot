package uz.shox.cachingwithspringboot;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import uz.shox.cachingwithspringboot.domains.Book;
import uz.shox.cachingwithspringboot.repos.BookRepository;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableCaching
public class CachingWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingWithSpringBootApplication.class, args);
	}
	    @Bean
	CommandLineRunner runner(BookRepository bookRepository) {
		return (args) -> {
			com.github.javafaker.Book book = new Faker().book();
			List<Book> books = IntStream.rangeClosed(1, 1000).mapToObj(i -> Book.builder()
					.name(book.title())
					.author(book.author())
					.genre(book.genre())
					.build()).toList();
			bookRepository.saveAll(books);
		};
	}

}
