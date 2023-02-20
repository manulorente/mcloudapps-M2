package mcloudapps.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.airport.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{
}
