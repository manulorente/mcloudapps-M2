package mcloudapps.airport.dto;

import java.util.Date;

public class FlightDTO {
    
    private String code;
    private String company;
    private Date departureDate;
    private String originAirport;
    private String originCity;

    public FlightDTO() {
    }

    public FlightDTO(String code, String company, Date departureDate, String originAirport, String originCity) {
        this.code = code;
        this.company = company;
        this.departureDate = departureDate;
        this.originAirport = originAirport;
        this.originCity = originCity;
    }

    @Override
    public String toString() {
        return "FlightDTO [code=" + code + ", company=" + company + ", departureDate=" + departureDate + ", originAirport="
                + originAirport + ", originCity=" + originCity + "]";
    }

}
