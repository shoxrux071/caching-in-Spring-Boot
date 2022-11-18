package uz.shox.cachingwithspringboot.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 18/11/22 18:14 (Friday)
 * caching-in-Spring-Boot/IntelliJ IDEA
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book implements Serializable{
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
    private String author;
    private String genre;
    private LocalDateTime createdAt;
}
