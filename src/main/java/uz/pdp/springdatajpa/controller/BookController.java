package uz.pdp.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springdatajpa.dto.BookDto;
import uz.pdp.springdatajpa.entity.BookEntity;
import uz.pdp.springdatajpa.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController extends BaseController {
    private final BookService bookService;

    @PostMapping("/create")
    public BookEntity create(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @GetMapping("/get/{id}")
    public BookEntity getById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        bookService.deleteById(id);
    }

//    @RequestMapping(value = "/search/page", method = RequestMethod.GET)
    @GetMapping("/search/page")
    public List<BookEntity> searchByPage(@RequestParam Integer page, @RequestParam boolean isMore) {
        return bookService.searchByPage(page, isMore);
    }

    @PutMapping("/update/{id}")
    public BookEntity update(@PathVariable(name = "id") Long id, @RequestBody BookDto update) {
        return bookService.update(update, id);
    }

    @GetMapping("/get-all")
    public List<BookEntity> getAll(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return bookService.findAll(page, size);
    }



}
