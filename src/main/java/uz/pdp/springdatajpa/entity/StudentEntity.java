package uz.pdp.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
}
