package sr.bbu.edu.kh.productservice.mappers;

import org.springframework.stereotype.Component;
import sr.bbu.edu.kh.productservice.dto.request.ProductRequest;
import sr.bbu.edu.kh.productservice.dto.response.ProductResponse;
import sr.bbu.edu.kh.productservice.entities.ProductEntity;

@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequest requestProduct){
        return ProductEntity.builder()
                .title(requestProduct.getTitle())
                .description(requestProduct.getDescription())
                .price(requestProduct.getPrice())
                .discount(requestProduct.getDiscount())
                .build();
    }

    public ProductResponse toResponse(ProductEntity requestProduct){
        return ProductResponse.builder()
                .title(requestProduct.getTitle())
                .description(requestProduct.getDescription())
                .price(requestProduct.getPrice())
                .discount(requestProduct.getDiscount())
                .build();
    }
}
