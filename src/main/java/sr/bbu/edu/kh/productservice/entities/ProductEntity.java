package sr.bbu.edu.kh.productservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "price", nullable = false, precision = 11, scale = 2)
    private BigDecimal price;

    @Column(name = "discount", precision = 11, scale = 2)
    private BigDecimal discount;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
}