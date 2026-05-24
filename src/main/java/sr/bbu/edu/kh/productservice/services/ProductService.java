package sr.bbu.edu.kh.productservice.services;

import sr.bbu.edu.kh.productservice.dto.request.ProductRequest;
import sr.bbu.edu.kh.productservice.dto.response.ProductResponse;
import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(int id);
    void createProduct(ProductRequest request);
    void updateProduct(int id, ProductRequest request);
    void deleteProduct(int id);
}