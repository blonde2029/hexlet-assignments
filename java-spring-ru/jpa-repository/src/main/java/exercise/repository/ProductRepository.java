package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    @Query("SELECT e FROM Product e WHERE e.price > :min and e.price < :max ORDER BY e.price")
    List<Product> findAllByPrice(@Param("min") int min, @Param("max") int max);

    @Query("SELECT e FROM Product e WHERE e.price > :min ORDER BY e.price")
    List<Product> findAllByPriceBiggerThan(@Param("min") int min);

    @Query("SELECT e FROM Product e WHERE e.price < :max ORDER BY e.price")
    List<Product> findAllByPriceLessThan(@Param("max") int max);

//    @Query("SELECT e FROM Product e ORDER BY e.price")
//    List<Product> findAll();
    // END
}
