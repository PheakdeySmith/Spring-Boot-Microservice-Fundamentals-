package sr.bbu.edu.kh.productservice.services.implement;

import sr.bbu.edu.kh.productservice.dto.request.ProductRequest;
import sr.bbu.edu.kh.productservice.entities.ProductEntity;
import sr.bbu.edu.kh.productservice.dto.response.ProductResponse;
import sr.bbu.edu.kh.productservice.repositories.ProductRepository;
import sr.bbu.edu.kh.productservice.mappers.ProductMapper;
import sr.bbu.edu.kh.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();

        productEntityList.forEach(data -> {
            ProductResponse productResponse = productMapper.toResponse(data);
            list.add(productResponse);
        });

        return list;
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity entity = productRepository.findbyId(id);
        if (entity == null) {
            throw new RuntimeException("Product not found");
        }
        return productMapper.toResponse(entity);
    }

    @Override
    public void createProduct(ProductRequest request) {
        ProductEntity entity = productMapper.toEntity(request);
        productRepository.save(entity);
    }

    @Override
    public void updateProduct(int id, ProductRequest request) {
        ProductEntity existingEntity = productRepository.findbyId(id);
        if (existingEntity == null) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        ProductEntity updatedEntity = productMapper.toEntity(request);
        updatedEntity.setId(id); // Plain integer assignment here bro

        productRepository.update(updatedEntity);
    }

    @Override
    public void deleteProduct(int id) {
        ProductEntity existingEntity = productRepository.findbyId(id);
        if (existingEntity == null) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}