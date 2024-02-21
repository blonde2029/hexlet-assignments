package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired AuthorMapper authorMapper;
    public List<AuthorDTO> findAll() {
        var authors = authorRepository.findAll();
        var result = authors
                .stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }

    public AuthorDTO findById(Long id) {
        var author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return authorMapper.map(author);
    }

    public AuthorDTO create(AuthorCreateDTO authorCreateDTO) {
        var author = authorMapper.map(authorCreateDTO);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

     public AuthorDTO update(AuthorUpdateDTO authorUpdateDTO, Long id) {
        var author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        authorMapper.update(authorUpdateDTO, author);
//        author.setFirstName(authorUpdateDTO.getFirstName());
         authorRepository.save(author);
         return authorMapper.map(author);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
