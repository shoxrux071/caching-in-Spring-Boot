package uz.shox.cachingwithspringboot.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 18/11/22 18:16 (Friday)
 * caching-in-Spring-Boot/IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookUpdateDto {
    private String id;
    private String name;
    private String author;
    private String genre;
}
