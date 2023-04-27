package uz.pdp.springdatajpa.config;

import org.postgresql.util.PSQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.springdatajpa.exception.DataNotFoundException;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataNotFoundException.class, PSQLException.class})
    public ResponseEntity<String> handleDataNotFoundException(Exception e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

//    @ExceptionHandler(value = PSQLException.class)
//    public ResponseEntity<String> handlePSQLException(PSQLException e) {
//        return ResponseEntity.status(400).body(e.getMessage());
//    }

}
