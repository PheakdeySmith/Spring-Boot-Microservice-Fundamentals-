package sr.bbu.edu.kh.productservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
}
