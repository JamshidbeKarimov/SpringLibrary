package uz.pdp.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.springdatajpa.dto.BookDto;
import uz.pdp.springdatajpa.entity.BookEntity;
import uz.pdp.springdatajpa.exception.DataNotFoundException;
import uz.pdp.springdatajpa.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookEntity create(BookDto bookDto) {
        return bookRepository.save(modelMapper.map(bookDto, BookEntity.class));
    }


    public List<BookEntity> findAll(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public BookEntity findById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> {
                    throw new DataNotFoundException("book not found");
                }
        );
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }


    public List<BookEntity> searchByPage(Integer page, boolean isMore) {
        if (isMore) {
            return bookRepository.findBookEntitiesByPagesAfter(page);
        }
        return bookRepository.findBookEntitiesByPagesBefore(page);
    }

    public BookEntity update(BookDto update, Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow(
                () -> { throw new DataNotFoundException("no book with this id");}
        );

        modelMapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(update, book);
        bookRepository.save(book);
        return book;
    }


}
