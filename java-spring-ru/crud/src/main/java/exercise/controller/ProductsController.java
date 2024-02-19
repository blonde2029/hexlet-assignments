package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.model.Category;
import exercise.repository.CategoryRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping(path = "")
    public List<ProductDTO> index() {
        var products = productRepository.findAll()
                .stream()
                .map(productMapper::map)
                .toList();
        return products;
    }

    @GetMapping(path = "/{id}")
    public ProductDTO show(@PathVariable long id) {
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id "
                + id + " not found"));
        return productMapper.map(product);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductCreateDTO productCreateData) {
//        var category = categoryRepository.findById(productCreateData.getCategoryId()).orElseThrow(()
//                -> new ResourceNotFoundException("Category with such id not found"));
        if (!categoryRepository.findById(productCreateData.getCategoryId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductDTO());
        }

        var product = productMapper.map(productCreateData);
        productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.map(product));
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@PathVariable long id, @Valid @RequestBody ProductUpdateDTO productUpdateData) {
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id "
                + id + " not found"));
        productMapper.update(productUpdateData, product);
        var category = categoryRepository.findById(productUpdateData.getCategoryId().get()).orElseThrow(()
                -> new ResourceNotFoundException("Category with id " + id + " not found"));
        product.setCategory(category);
        productRepository.save(product);
        return productMapper.map(product);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        productRepository.deleteById(id);
    }
    // END
}
