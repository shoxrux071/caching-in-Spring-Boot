package uz.shox.cachingwithspringboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shox.cachingwithspringboot.domains.Book;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 18/11/22 18:22 (Friday)
 * caching-in-Spring-Boot/IntelliJ IDEA
 */
@Repository
public interface BookRepository extends JpaRepository<Book ,String> {
}
