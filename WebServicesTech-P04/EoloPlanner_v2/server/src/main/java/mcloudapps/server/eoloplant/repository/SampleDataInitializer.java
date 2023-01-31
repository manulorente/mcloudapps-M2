package mcloudapps.server.eoloplant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import mcloudapps.server.eoloplant.model.EoloPlant;

@Component
public class SampleDataInitializer {

    @Autowired
    private EoloPlantRepository eoloPlants;

    @PostConstruct
    public void init() {
        EoloPlant eoloPlant = new EoloPlant("Madrid", "madrid-sunny-flat");
        eoloPlant.setCompleted(true);
        eoloPlant.setProgress(100);
        this.eoloPlants.save(eoloPlant);
        eoloPlant = new EoloPlant("Barcelona", "barcelona-sunny-flat");
        eoloPlant.setCompleted(true);
        eoloPlant.setProgress(100);
        this.eoloPlants.save(eoloPlant);
        eoloPlant = new EoloPlant("Valencia", "valencia-sunny-flat");
        eoloPlant.setCompleted(true);
        eoloPlant.setProgress(100);
        this.eoloPlants.save(eoloPlant);
    }
    
}
