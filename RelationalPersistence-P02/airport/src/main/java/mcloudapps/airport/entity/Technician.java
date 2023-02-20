package mcloudapps.airport.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "Technician")
public class Technician extends Employee{

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "education")
    private String education;

    @OneToMany(mappedBy = "technician", fetch = FetchType.EAGER)
    private List<Overhaul> overhauls = new ArrayList<>();

    public Technician() {
    }

    public Technician(String employeeCode, String name, String surname, String company, int startYear, String education) {
        super(employeeCode, name, surname, company);
        this.startYear = startYear;
        this.education = education;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(int incorporationYear) {
        this.startYear = incorporationYear;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString()
    {
        return "Technician [education=" + education + ", startYear=" + startYear + ", employeeCode=" + getEmployeeCode() + 
        ", name=" + getName() + ", surname=" + getSurname() + ", company=" + getCompany() + "]";
    }

    
}
