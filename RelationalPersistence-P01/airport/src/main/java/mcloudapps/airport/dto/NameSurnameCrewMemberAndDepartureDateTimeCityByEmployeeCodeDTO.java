package mcloudapps.airport.dto;

public class NameSurnameCrewMemberAndDepartureDateTimeCityByEmployeeCodeDTO {
    
    private String name;

    private String surname;

    private String departureDateTime;

    private String city;

    public NameSurnameCrewMemberAndDepartureDateTimeCityByEmployeeCodeDTO() {
    }

    public NameSurnameCrewMemberAndDepartureDateTimeCityByEmployeeCodeDTO(String name, String surname, String departureDateTime, String city) {
        this.name = name;
        this.surname = surname;
        this.departureDateTime = departureDateTime;
        this.city = city;
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

    public String getDepartureDateTime() {
        return this.departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", departureDateTime='" + getDepartureDateTime() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
}