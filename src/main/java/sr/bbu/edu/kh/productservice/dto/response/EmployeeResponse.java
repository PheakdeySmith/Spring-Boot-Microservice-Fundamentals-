package sr.bbu.edu.kh.productservice.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String address;
    private Double salary;
}