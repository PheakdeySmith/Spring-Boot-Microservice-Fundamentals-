package sr.bbu.edu.kh.productservice.repositories;

import org.springframework.stereotype.Repository;
import sr.bbu.edu.kh.productservice.entities.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final List<EmployeeEntity> employeeEntities = new ArrayList<>();

    public EmployeeRepository() {
        if (employeeEntities.isEmpty()) {
            employeeEntities.add(new EmployeeEntity(1, "John", "Doe", "john.doe@bbu.edu.kh", "Male", "012345678", "Phnom Penh", 500.0));
            employeeEntities.add(new EmployeeEntity(2, "Jane", "Smith", "jane.smith@bbu.edu.kh", "Female", "098765432", "Siem Reap", 600.0));
        }
    }

    public List<EmployeeEntity> findAll() {
        return employeeEntities;
    }

    public EmployeeEntity findbyId(int id) {
        for (EmployeeEntity data : employeeEntities) {
            if (data.getId() == id) {
                return data;
            }
        }
        return null;
    }

    public void save(EmployeeEntity request) {
        request.setId(employeeEntities.size() + 1);
        employeeEntities.add(request);
    }

    public void update(EmployeeEntity updatedEntity) {
        for (int i = 0; i < employeeEntities.size(); i++) {
            if (employeeEntities.get(i).getId() == updatedEntity.getId()) {
                employeeEntities.set(i, updatedEntity);
                return;
            }
        }
    }

    public void deleteById(int id) {
        employeeEntities.removeIf(data -> data.getId() == id);
    }
}