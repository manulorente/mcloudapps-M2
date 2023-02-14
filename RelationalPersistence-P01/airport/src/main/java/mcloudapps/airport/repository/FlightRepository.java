package mcloudapps.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.airport.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
    
 }
