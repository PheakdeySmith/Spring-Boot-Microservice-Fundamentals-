package sr.bbu.edu.kh.productservice.mappers;

import org.springframework.stereotype.Component;
import sr.bbu.edu.kh.productservice.dto.request.EmployeeRequest;
import sr.bbu.edu.kh.productservice.dto.response.EmployeeResponse;
import sr.bbu.edu.kh.productservice.entities.EmployeeEntity;

@Component
public class EmployeeMapper {
    public EmployeeEntity toEntity(EmployeeRequest request) {
        return EmployeeEntity.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .gender(request.getGender())
                .phone(request.getPhone())
                .address(request.getAddress())
                .salary(request.getSalary())
                .build();
    }

    public EmployeeResponse toResponse(EmployeeEntity entity) {
        return EmployeeResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .salary(entity.getSalary())
                .build();
    }
}