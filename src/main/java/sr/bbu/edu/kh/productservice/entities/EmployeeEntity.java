package sr.bbu.edu.kh.productservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String address;
    private Double salary;
}