package sr.bbu.edu.kh.productservice.controllers;

import org.springframework.web.bind.annotation.*;
import sr.bbu.edu.kh.productservice.dto.request.EmployeeRequest;
import sr.bbu.edu.kh.productservice.dto.response.EmployeeResponse;
import sr.bbu.edu.kh.productservice.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") int id) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeResponse);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequest request) {
        employeeService.createEmployee(request);
        return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeRequest request) {
        employeeService.updateEmployee(id, request);
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}