package mcloudapps.airport.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity(name = "FlightCrewMember")
public class FlightCrewMember {

    @EmbeddedId
    private FlightCrewMemberId id;

    @ManyToOne
    @MapsId("flightId")
    private Flight flight;

    @ManyToOne
    @MapsId("crewMemberId")
    private CrewMember crewMember;

    public FlightCrewMember() {
    }

    public FlightCrewMember(Flight flight, CrewMember crewMember) {
        this.flight = flight;
        this.crewMember = crewMember;
        this.id = new FlightCrewMemberId(flight.getId(), crewMember.getId());
    }
    
}
