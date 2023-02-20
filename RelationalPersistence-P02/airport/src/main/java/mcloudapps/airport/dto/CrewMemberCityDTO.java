package mcloudapps.airport.dto;

import java.util.Date;

public class CrewMemberCityDTO {
    
    private String name;

    private String surname;

    private Date departureDate;

    private String city;

    public CrewMemberCityDTO() {
    }

    public CrewMemberCityDTO(String name, String surname, Date departureDate, String city) {
        this.name = name;
        this.surname = surname;
        this.departureDate = departureDate;
        this.city = city;
    }

    @Override
    public String toString() {
        return "CrewMemberCityDTO [city=" + city + ", departureDate=" + departureDate + ", name=" + name + ", surname="
                + surname + "]";
    }
}