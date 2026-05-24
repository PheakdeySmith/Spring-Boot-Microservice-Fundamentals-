package sr.bbu.edu.kh.productservice.mappers;

import org.springframework.stereotype.Component;
import sr.bbu.edu.kh.productservice.dto.request.ProductRequest;
import sr.bbu.edu.kh.productservice.dto.response.ProductResponse;
import sr.bbu.edu.kh.productservice.entities.ProductEntity;
import java.math.BigDecimal;

@Component
public class ProductMapper {

    public ProductEntity toEntity(ProductRequest requestProduct) {
        if (requestProduct == null) return null;

        return ProductEntity.builder()
                .title(requestProduct.getTitle())
                .description(requestProduct.getDescription())
                // Convert Double -> BigDecimal safely
                .price(requestProduct.getPrice() != null ? BigDecimal.valueOf(requestProduct.getPrice()) : null)
                .discount(requestProduct.getDiscount() != null ? BigDecimal.valueOf(requestProduct.getDiscount()) : null)
                .build();
    }

    public ProductResponse toResponse(ProductEntity productEntity) {
        if (productEntity == null) return null;

        return ProductResponse.builder()
                .title(productEntity.getTitle())
                .description(productEntity.getDescription())
                // Convert BigDecimal -> Double safely
                .price(productEntity.getPrice() != null ? productEntity.getPrice().doubleValue() : null)
                .discount(productEntity.getDiscount() != null ? productEntity.getDiscount().doubleValue() : null)
                .build();
    }
}