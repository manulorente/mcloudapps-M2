package mcloudapps.server.eoloplant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.server.eoloplant.model.EoloPlant;

public interface EoloPlantRepository extends JpaRepository<EoloPlant, Long>{
    
}
