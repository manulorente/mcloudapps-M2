package mcloudapps.airport.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class FlightCrewMemberId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long flightId;
    private Long crewMemberId;

    public FlightCrewMemberId() {
    }

    public FlightCrewMemberId(Long flightId, Long crewMemberId) {
        this.flightId = flightId;
        this.crewMemberId = crewMemberId;
    }

    public Long getFlightId() {
        return this.flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getCrewMemberId() {
        return this.crewMemberId;
    }

    public void setCrewMemberId(Long crewMemberId) {
        this.crewMemberId = crewMemberId;
    }
    
}
