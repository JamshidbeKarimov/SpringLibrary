package uz.pdp.springdatajpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private String author;
    private Integer pages;
}
