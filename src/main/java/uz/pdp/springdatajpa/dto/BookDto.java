package uz.pdp.springdatajpa.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private String name;
    private String author;
    private Integer pages;
}
