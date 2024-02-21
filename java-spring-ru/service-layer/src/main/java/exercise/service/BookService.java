package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired BookMapper bookMapper;

    public List<BookDTO> findAll() {
        var books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return bookMapper.map(book);
    }

    public BookDTO create(BookCreateDTO bookCreateDTO) {
        var book = bookMapper.map(bookCreateDTO);
        var author = authorRepository.findById(bookCreateDTO.getAuthorId()).orElseThrow(()
                -> new ResourceNotFoundException("Not found"));
        book.setAuthor(author);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO update(BookUpdateDTO bookUpdateDTO, Long id) {
        var book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        bookMapper.update(bookUpdateDTO, book);
//        var author = authorRepository.findById(bookUpdateDTO.getAuthorId()).orElseThrow();
//        book.setAuthor();
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
