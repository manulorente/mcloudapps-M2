package mcloudapps.airport.dto;

import java.time.LocalDateTime;

public class FlightByOriginDTO {
    
    private String code;
    private String company;
    private LocalDateTime departureDateTime;
    private String originAirport;
    private String originCity;

    public FlightByOriginDTO() {
    }

    public FlightByOriginDTO(String code, String company, LocalDateTime departureDateTime, String originAirport, String originCity) {
        this.code = code;
        this.company = company;
        this.departureDateTime = departureDateTime;
        this.originAirport = originAirport;
        this.originCity = originCity;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getDepartureDateTime() {
        return this.departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureTime) {
        this.departureDateTime = departureTime;
    }

    public String getOriginAirport() {
        return this.originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getOriginCity() {
        return this.originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

}
