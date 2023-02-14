package mcloudapps.airport.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flight_code")
    private String flightCode;

    @Column(name = "company_name")
    private String company;

    @Column(name = "departure_datetime")
    private String departureDateTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "flight_duration")
	private BigDecimal flightDuration;

    @OneToOne
    private Plane plane;

    @OneToOne
    private Airport departureAirport;

    @OneToOne
    private Airport arrivalAirport;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightCrewMember> crewMember = new ArrayList<>();

    public Flight() {
    }

    public Flight(String flightCode, String company, Airport departureAirport, Airport arrivalAirport, String departureTime,
            String arrivalTime, BigDecimal flightDuration, Plane plane) {
        this.flightCode = flightCode;
        this.company = company;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDuration = flightDuration;
        this.plane = plane;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightCode() {
        return this.flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureDateTime() {
        return this.departureDateTime;
    }

    public void setDepartureDateTime(String departureTime) {
        this.departureDateTime = departureTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<FlightCrewMember> getCrewMember() {
        return this.crewMember;
    }

    public void setCrewMember(List<FlightCrewMember> flightCrew) {
        this.crewMember = flightCrew;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public BigDecimal getFlightDuration() {
        return this.flightDuration;
    }

    public void setFlightDuration(BigDecimal flightDuration) {
        this.flightDuration = flightDuration;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", flightCode='" + getFlightCode() + "'" +
            ", company='" + getCompany() + "'" +
            ", departureAirport='" + getDepartureAirport() + "'" +
            ", arrivalAirport='" + getArrivalAirport() + "'" +
            ", departureDateTime='" + getDepartureDateTime() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", flightDuration='" + getFlightDuration() + "'" +
            ", plane='" + getPlane() + "'" +
            "}";
    }
    
}
