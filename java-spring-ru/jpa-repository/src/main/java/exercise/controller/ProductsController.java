package exercise.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> index(@PathParam("min") String min, @PathParam("max") String max) {
        if (min != null && max != null && Integer.parseInt(min) > 0 && Integer.parseInt(max) > 0) {
            return productRepository.findAllByPrice(Integer.parseInt(min), Integer.parseInt(max));
        } else if (min != null && Integer.parseInt(min) > 0) {
            return productRepository.findAllByPriceBiggerThan(Integer.parseInt(min));
        } else if (max != null && Integer.parseInt(max) > 0) {
            return productRepository.findAllByPriceLessThan(Integer.parseInt(max));
        } else {
            return productRepository.findAll();
        }
    }

//    @GetMapping(path = "")
//    public List<Product> index() {
//        return productRepository.findAll();
//    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
