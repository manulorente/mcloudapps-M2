package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mcloudapps.airport.dto.CrewMemberNamesurnameSumFlightHoursAndFlightsNumberDTO;
import mcloudapps.airport.entity.FlightCrewMember;

public interface FlightCrewMemberRepository extends JpaRepository<FlightCrewMember, Long>{
    
    /* 
    @Query("SELECT new mcloudapps.airport.dto.CrewMemberNamesurnameSumFlightHoursAndFlightsNumberDTO(c.name, c.surname, SUM(f.flightDuration), COUNT(fcm.flight.id)) "
            + "FROM CrewMember c, FlightCrewMember fcm, flight f "
            + "WHERE fcm.flight.id = f.id "
            + "AND fcm.crewMember.id = c.id "
            + "GROUP BY c.id")
    List<CrewMemberNamesurnameSumFlightHoursAndFlightsNumberDTO> findAllCrewMembersNumberOfHoursAndFlights();
    */
    
}
