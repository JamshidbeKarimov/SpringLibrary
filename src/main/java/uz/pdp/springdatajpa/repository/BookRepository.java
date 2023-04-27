package uz.pdp.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springdatajpa.entity.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findBookEntitiesByAuthorContainingIgnoreCase(String author);
    List<BookEntity> findBookEntitiesByNameContainingIgnoreCase(String name);
    List<BookEntity> findBookEntitiesByPagesAfter(Integer pages);
    List<BookEntity> findBookEntitiesByPagesBefore(Integer pages);

}
