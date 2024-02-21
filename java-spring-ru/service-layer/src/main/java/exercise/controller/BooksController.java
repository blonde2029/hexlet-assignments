package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    AuthorRepository authorRepository;
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookDTO>> index() {
        var booksDTO = bookService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(booksDTO);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> show(@PathVariable Long id) {
        var book = bookService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(book);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookCreateDTO bookCreateDTO) {
        if (!authorRepository.findById(bookCreateDTO.getAuthorId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BookDTO());
        }

        bookService.create(bookCreateDTO);
        var book = bookMapper.map(bookCreateDTO);
        var bookDTO = bookMapper.map(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookDTO);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @Valid @RequestBody BookUpdateDTO bookUpdateDTO) {
        bookService.update(bookUpdateDTO, id);
        var bookDTO = bookService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookDTO);
    }
    // END
}
