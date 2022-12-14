package mcloudapps.server.eoloplant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import mcloudapps.server.eoloplant.model.EoloPlant;

@Component
public class SampleDataInitializer {

    @Autowired
    private EoloPlantRepository eoloPlantRepository;

    @PostConstruct
    public void init() {
        EoloPlant eoloPlant = new EoloPlant("Roma");
        this.eoloPlantRepository.save(eoloPlant);

        eoloPlant = new EoloPlant("Milano");
        this.eoloPlantRepository.save(eoloPlant);
    }
    
}
