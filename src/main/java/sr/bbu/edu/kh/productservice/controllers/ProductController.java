package sr.bbu.edu.kh.productservice.controllers;

import org.springframework.web.bind.annotation.*;
import sr.bbu.edu.kh.productservice.dto.request.ProductRequest;
import sr.bbu.edu.kh.productservice.dto.response.ProductResponse;
import sr.bbu.edu.kh.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") int id) {
        ProductResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok(productResponse);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest request) {
        productService.createProduct(request);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody ProductRequest request) {
        productService.updateProduct(id, request);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}