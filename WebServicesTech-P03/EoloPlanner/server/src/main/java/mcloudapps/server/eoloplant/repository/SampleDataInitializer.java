package mcloudapps.server.eoloplant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import mcloudapps.server.eoloplant.model.EoloPlant;

@Component
public class SampleDataInitializer {

    @Autowired
    private EoloPlantRepository eoloPlants;

    @PostConstruct
    public void init() {
        this.eoloPlants.save(new EoloPlant("Madrid", "madrid-sunny-flat"));
        this.eoloPlants.save(new EoloPlant("Barcelona", "barcelona-sunny-mountain"));
        this.eoloPlants.save(new EoloPlant("Valencia", "valencia-sunny-flat"));
    }
    
}
