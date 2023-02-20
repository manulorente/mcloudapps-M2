package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mcloudapps.airport.dto.FlightDTO;

import mcloudapps.airport.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

    @Query("SELECT new mcloudapps.airport.dto.FlightDTO(f.flightCode, f.company, f.departureDate, a.name, a.city) "
    + "FROM Airport a, Flight f "
    + "WHERE LOWER(a.city) like LOWER(:city) "
    + "AND f.departureDate >= STR_TO_DATE(:departureDate, '%d/%m/%Y') "
    + "AND f.departureDate < STR_TO_DATE(:departureDate, '%d/%m/%Y') + 1 "
    + "ORDER BY f.departureDate")
    List <FlightDTO> findAllFlightsGivenCityAndDateOrderedByDepartureTime(@Param("city") String city, @Param("departureDate") String departureDate);

 }
