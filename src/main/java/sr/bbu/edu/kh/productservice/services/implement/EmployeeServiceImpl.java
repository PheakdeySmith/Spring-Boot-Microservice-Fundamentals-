package sr.bbu.edu.kh.productservice.services.implement;

import sr.bbu.edu.kh.productservice.dto.request.EmployeeRequest;
import sr.bbu.edu.kh.productservice.entities.EmployeeEntity;
import sr.bbu.edu.kh.productservice.dto.response.EmployeeResponse;
import sr.bbu.edu.kh.productservice.repositories.EmployeeRepository;
import sr.bbu.edu.kh.productservice.mappers.EmployeeMapper;
import sr.bbu.edu.kh.productservice.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<EmployeeResponse> list = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        employeeEntityList.forEach(data -> {
            EmployeeResponse employeeResponse = employeeMapper.toResponse(data);
            list.add(employeeResponse);
        });

        return list;
    }

    @Override
    public EmployeeResponse getEmployeeById(int id) {
        EmployeeEntity entity = employeeRepository.findbyId(id);
        if (entity == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return employeeMapper.toResponse(entity);
    }

    @Override
    public void createEmployee(EmployeeRequest request) {
        EmployeeEntity entity = employeeMapper.toEntity(request);
        employeeRepository.save(entity);
    }

    @Override
    public void updateEmployee(int id, EmployeeRequest request) {
        EmployeeEntity existingEntity = employeeRepository.findbyId(id);
        if (existingEntity == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        EmployeeEntity updatedEntity = employeeMapper.toEntity(request);
        updatedEntity.setId(id);

        employeeRepository.update(updatedEntity);
    }

    @Override
    public void deleteEmployee(int id) {
        EmployeeEntity existingEntity = employeeRepository.findbyId(id);
        if (existingEntity == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}