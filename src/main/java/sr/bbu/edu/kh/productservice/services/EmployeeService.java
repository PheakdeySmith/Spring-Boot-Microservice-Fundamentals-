package sr.bbu.edu.kh.productservice.services;

import sr.bbu.edu.kh.productservice.dto.request.EmployeeRequest;
import sr.bbu.edu.kh.productservice.dto.response.EmployeeResponse;
import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(int id);
    void createEmployee(EmployeeRequest request);
    void updateEmployee(int id, EmployeeRequest request);
    void deleteEmployee(int id);
}