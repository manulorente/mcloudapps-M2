package mcloudapps.airport.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "CrewMember")
public class CrewMember extends Employee{

    @Column(name = "job_position")
    private String role;

    @OneToMany(mappedBy = "crewMember", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FlightCrewMember> flights = new ArrayList<>();

    public CrewMember() {
    }

    public CrewMember(String employeeCode, String name, String surname, String role, String company) {
        super(employeeCode, name, surname, company);
        this.role = role;
    }


    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
            "employeeCode='" + getEmployeeCode() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", role='" + getRole() + "'" +
            ", company='" + getCompany() + "'" +
            "}";
    }
    
}
