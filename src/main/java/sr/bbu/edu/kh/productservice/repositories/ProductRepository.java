package sr.bbu.edu.kh.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sr.bbu.edu.kh.productservice.entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}