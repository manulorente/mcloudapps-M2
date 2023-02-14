package mcloudapps.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.airport.entity.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    
}
