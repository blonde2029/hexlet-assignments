package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.mapper.AuthorMapper;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @Autowired
    private AuthorMapper authorMapper;
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AuthorDTO>> index() {
        var authors = authorService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authors);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AuthorDTO> show(@PathVariable Long id) {
        var author = authorService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(author);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthorDTO> create(@Valid @RequestBody AuthorCreateDTO authorCreateDTO) {
        authorService.create(authorCreateDTO);
        var author = authorMapper.map(authorCreateDTO);
        var authorDTO = authorMapper.map(author);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorDTO);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthorDTO> update(@PathVariable Long id, @Valid @RequestBody AuthorUpdateDTO authorUpdateDTO) {
        authorService.update(authorUpdateDTO, id);
        var authorDTO = authorService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        authorService.delete(id);
    }
    // END
}
