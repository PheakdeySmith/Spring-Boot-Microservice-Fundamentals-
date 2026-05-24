package sr.bbu.edu.kh.productservice.repositories;

import org.springframework.stereotype.Repository;
import sr.bbu.edu.kh.productservice.entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<ProductEntity> productsEntities = new ArrayList<>();

    public ProductRepository() {
        if (productsEntities.isEmpty()) {
            // Using standard int values for IDs now bro
            productsEntities.add(new ProductEntity(1, "Coca", "Taste good", 12.90, 10.0));
            productsEntities.add(new ProductEntity(2, "Pepsi", "Taste bad", 10.0, 10.0));
        }
    }

    public List<ProductEntity> findAll() {
        return productsEntities;
    }

    public ProductEntity findbyId(int id) {
        for (ProductEntity data : productsEntities) {
            if (data.getId() == id) {
                return data;
            }
        }
        return null;
    }

    public void save(ProductEntity request) {
        request.setId(productsEntities.size() + 1);
        productsEntities.add(request);
    }

    public void update(ProductEntity updatedEntity) {
        for (int i = 0; i < productsEntities.size(); i++) {
            if (productsEntities.get(i).getId() == updatedEntity.getId()) {
                productsEntities.set(i, updatedEntity);
                return;
            }
        }
    }

    public void deleteById(int id) {
        productsEntities.removeIf(data -> data.getId() == id);
    }
}