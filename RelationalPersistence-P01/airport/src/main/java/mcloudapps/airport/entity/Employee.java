package mcloudapps.airport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(name = "employee_code") 
    private String employeeCode;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_name")
    private String company;

    public Employee() {
    }

    public Employee(String employeeCode, String name, String surname, String company) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return this.employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "{" + " employeeCode='" + getEmployeeCode() + "'" + ", name='" + getName() + "'" + ", surname='"
                + getSurname() + "'" + ", company='" + getCompany() + "'" + "}";
    }
    
}
