package mcloudapps.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mcloudapps.airport.dto.PlaneOverhaulDTO;
import mcloudapps.airport.entity.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long>{
    
    @Query("SELECT DISTINCT new mcloudapps.airport.dto.PlaneOverhaulDTO(p.plate, t.name, t.surname) "
            + "FROM Overhaul o "
            + "JOIN Plane p on p.id = o.plane.id "
            + "JOIN Technician t on t.id = o.technician.id ")
    List <PlaneOverhaulDTO> findAllPlanesByTechnicianAndOverhaul();
}
