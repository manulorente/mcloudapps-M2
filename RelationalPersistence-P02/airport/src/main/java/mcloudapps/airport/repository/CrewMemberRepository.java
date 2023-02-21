package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mcloudapps.airport.dto.CrewMemberFlightDTO;
import mcloudapps.airport.dto.CrewMemberCityDTO;
import mcloudapps.airport.entity.CrewMember;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {
    
    @Query("SELECT new mcloudapps.airport.dto.CrewMemberCityDTO(c.name, c.surname, f.departureDate, a.city) "
            + "FROM CrewMember c, Flight f, Airport a "
            + "WHERE c.employeeCode like :employeeCode "
            + "AND f.departureAirport.id = a.id")
    List<CrewMemberCityDTO> findAllCrewMembersDepartureDataByEmployeeCode(@Param("employeeCode") String employeeCode);

    @Query("SELECT new mcloudapps.airport.dto.CrewMemberFlightDTO(c.name, c.surname, COUNT(f), SUM(f.flightDuration)) "
            + "FROM Flight f, CrewMember c, FlightCrewMember fcm "
            + "WHERE fcm.flight.id = f.id "
            + "AND fcm.crewMember.id = c.id "
            + "GROUP BY c.name, c.surname " 
            + "ORDER BY 3")
    List<CrewMemberFlightDTO> findAllCrewMembersNumberOfHoursAndFlights();
    
    @Query(value = "SELECT c.name AS crewMemberName, c.surname AS crewMemberSurname, COUNT(f.id) AS numberOfFlights, SUM(f.flight_duration) AS numberOfHours "
                + "FROM test.crew_member c, test.flight f, test.flight_crew_member fcm "
                + "WHERE fcm.flight_id = f.id "
                + "AND fcm.crew_member_id = c.id "
                + "GROUP BY c.name, c.surname "
                + "ORDER BY 3",
                nativeQuery = true)
    List<Object> findAllCrewMembersNumberOfHoursAndFlightsJson();
}
