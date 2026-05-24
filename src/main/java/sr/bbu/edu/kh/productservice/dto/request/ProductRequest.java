package sr.bbu.edu.kh.productservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
}