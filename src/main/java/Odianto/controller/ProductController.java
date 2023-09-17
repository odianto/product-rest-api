package Odianto.controller;

import Odianto.exception.ProductRegistrationException;
import Odianto.model.Product;
import Odianto.request.RequestPayload;
import Odianto.response.ResponsePayload;
import Odianto.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct() {
        return productService.findAllProducts();
    }

    @GetMapping("/findProduct/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        return productService.findProductById(productId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductRegistrationException("Product with Product ID "+ productId+" not exists"));
    }

    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponsePayload createProduct(@RequestBody @Valid RequestPayload request) {
        Product product = new Product();
        ResponsePayload responsePayload = new ResponsePayload();
        try {
            product.setProductId(request.getProductId());
            product.setProductName(request.getProductName());
            product.setProductDescription(request.getProductDescription());
            product.setProductPrice(request.getPrice());
            product.setProductVariety(request.getVariety());
            product.setProductRating(request.getRating());
            product.setProductStock(request.getStock());
            product.setCreatedDate(new Date());
            product.setCreatedBy("System");
            productService.createProduct(product);
            responsePayload.setStatus("Success");
            responsePayload.setErrorMessage("ok");
        }
        catch(Exception e){
            responsePayload.setStatus("Failed");
            responsePayload.setErrorMessage(e.getMessage());
        }
        return responsePayload;
    }

    @PostMapping("/updateProduct")
    public ResponsePayload updateProduct(@RequestBody @Valid RequestPayload request) {
        Product product = new Product();
        ResponsePayload responsePayload = new ResponsePayload();
        try {
            product.setProductId(request.getProductId());
            product.setProductName(request.getProductName());
            product.setProductDescription(request.getProductDescription());
            product.setProductPrice(request.getPrice());
            product.setProductVariety(request.getVariety());
            product.setProductRating(request.getRating());
            product.setProductStock(request.getStock());
            product.setModifyDate(new Date());
            product.setModifyBy("System");
            productService.updateProduct(product);
            responsePayload.setStatus("Success");
            responsePayload.setErrorMessage("ok");
        }
        catch(Exception e){
            responsePayload.setStatus("Failed");
            responsePayload.setErrorMessage(e.getMessage());
        }
        return responsePayload;
    }

    @GetMapping("/deleteProduct/{productId}")
    public ResponsePayload deleteProduct(@PathVariable String productId) {
        ResponsePayload responsePayload = new ResponsePayload();
        try {
            productService.deleteProductById(productId);
            responsePayload.setStatus("Success");
            responsePayload.setErrorMessage("ok");
        }
        catch(Exception e){
            responsePayload.setStatus("Failed");
            responsePayload.setErrorMessage(e.getMessage());
        }
        return responsePayload;
    }
}
