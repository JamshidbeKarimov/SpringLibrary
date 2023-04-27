package uz.pdp.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.springdatajpa.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

//    @Query(value = "select s from student s where s.username = :username")
    Optional<StudentEntity> findStudentEntitiesByUsername(String username);



}
