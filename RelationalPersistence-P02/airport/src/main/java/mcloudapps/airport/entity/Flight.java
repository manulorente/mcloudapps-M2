package mcloudapps.airport.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "flight_duration")
	private Double flightDuration;

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

    public Flight(String flightCode, String company, Plane plane, Airport departureAirport, Airport arrivalAirport, 
                Date departureDate, Double flightDuration) {
        this.flightCode = flightCode;
        this.company = company;
        this.plane = plane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.flightDuration = flightDuration;
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

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
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

    public Double getFlightDuration() {
        return this.flightDuration;
    }

    public void setFlightDuration(Double flightDuration) {
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
            ", departureDate='" + getDepartureDate() + "'" +
            ", flightDuration='" + getFlightDuration() + "'" +
            ", plane='" + getPlane() + "'" +
            "}";
    }
    
}
