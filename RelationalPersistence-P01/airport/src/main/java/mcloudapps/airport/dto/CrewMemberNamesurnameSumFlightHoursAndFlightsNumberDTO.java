package mcloudapps.airport.dto;

import java.math.BigDecimal;

public class CrewMemberNamesurnameSumFlightHoursAndFlightsNumberDTO {

    private String name;

    private String surname;

    private BigDecimal sumFlightHours;

    private Long flightsNumber;

    public CrewMemberNamesurnameSumFlightHoursAndFlightsNumberDTO(String name, String surname, BigDecimal sumFlightHours, Long flightsNumber) {
        this.name = name;
        this.surname = surname;
        this.sumFlightHours = sumFlightHours;
        this.flightsNumber = flightsNumber;
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

    public BigDecimal getSumFlightHours() {
        return this.sumFlightHours;
    }

    public void setSumFlightHours(BigDecimal sumFlightHours) {
        this.sumFlightHours = sumFlightHours;
    }

    public Long getFlightsNumber() {
        return this.flightsNumber;
    }

    public void setFlightsNumber(Long flightsNumber) {
        this.flightsNumber = flightsNumber;
    }
    
}
