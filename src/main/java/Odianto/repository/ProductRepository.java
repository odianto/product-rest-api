package Odianto.repository;

import Odianto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select p from Product p where p.productId=?1")
    Optional<Product> findProduct(String productId);

}
