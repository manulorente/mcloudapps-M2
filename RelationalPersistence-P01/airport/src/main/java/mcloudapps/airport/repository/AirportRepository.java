package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mcloudapps.airport.dto.FlightByOriginDTO;
import mcloudapps.airport.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{
       
    @Query("SELECT new mcloudapps.airport.dto.FlightByOriginDTO(f.flightCode, f.company, f.departureDateTime, a.name, a.city) "
            + "FROM Airport a, Flight f "
            + "WHERE LOWER(a.city) like LOWER(:city) "
            + "AND DATE_FORMAT(f.departureDateTime, '%Y-%m-%d') = :departureDateTime "
            + "AND f.departureAirport.id = a.id "
            + "ORDER BY f.departureDateTime")
    List <FlightByOriginDTO> findAllFlightsGivenCityAndDateOrderedByDepartureTime(@Param("city") String city, @Param("departureDateTime") String departureDateTime);

}
