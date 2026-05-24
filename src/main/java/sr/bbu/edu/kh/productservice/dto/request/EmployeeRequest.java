package sr.bbu.edu.kh.productservice.dto.request;

public class EmployeeRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String address;
    private Double salary;

    public EmployeeRequest() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}