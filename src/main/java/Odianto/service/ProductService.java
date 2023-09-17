package Odianto.service;

import Odianto.exception.ProductRegistrationException;
import Odianto.model.Product;
import Odianto.repository.ProductRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findProduct(String productId) {
        return productRepository.findProduct(productId);
    }

    public Product createProduct(Product product) {
        Optional<Product> productFounded = productRepository.findProduct(product.getProductId());
        if(productFounded.isPresent()) {
            throw new ProductRegistrationException("Product with Product ID "+ product.getProductId()+" already exists");
        }
        if(StringUtils.isBlank(product.getProductId())){
            throw new ProductRegistrationException("Product ID is Mandatory Field");
        }
        if(StringUtils.isBlank(product.getProductName())) {
            throw new ProductRegistrationException("Product Name is Mandatory Field");
        }
        if(product.getProductPrice() <= 0) {
            throw new ProductRegistrationException("Price is Mandatory Field");
        }
        if(StringUtils.isBlank(product.getProductVariety())){
            throw new ProductRegistrationException("Variety is Mandatory Field");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        Optional<Product> productFounded = productRepository.findProduct(product.getProductId());
        if(!productFounded.isPresent()) {
            throw new ProductRegistrationException("Product with Product ID " + product.getProductId() + " not exists");
        }
        if(StringUtils.isBlank(product.getProductName())){
            product.setProductName(productFounded.get().getProductName());
        }
        if(StringUtils.isBlank(product.getProductDescription())){
            product.setProductDescription(productFounded.get().getProductDescription());
        }
        if(product.getProductPrice() <= 0) {
            product.setProductPrice(productFounded.get().getProductPrice());
        }
        if(StringUtils.isBlank(product.getProductVariety())){
            product.setProductVariety(productFounded.get().getProductVariety());
        }
        if(product.getProductRating() <= 0){
            product.setProductRating(productFounded.get().getProductRating());
        }
        if(product.getProductStock() <= 0){
            product.setProductStock(productFounded.get().getProductStock());
        }
        product.setCreatedDate(productFounded.get().getCreatedDate());
        product.setCreatedBy(productFounded.get().getCreatedBy());
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(String productId) {
        return productRepository.findProduct(productId);
    }

    public void deleteProductById(String productId) {
        Optional<Product> productFounded = productRepository.findProduct(productId);
        if(!productFounded.isPresent()) {
            throw new ProductRegistrationException("Product with Product ID " + productId + " not exists");
        }
        productRepository.deleteById(productId);
    }
}
