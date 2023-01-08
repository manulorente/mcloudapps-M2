package mcloudapps.server.eoloplant.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cloud.stream.function.StreamBridge;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks.Many;

import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.repository.EoloPlantRepository;

@Service
public class EoloPlantService {

    @Autowired
    private Flux<EoloPlant> eoloPlantEvents;

    @Autowired
  	private Many<EoloPlant> eoloPlantSink;

    @Autowired
    private StreamBridge streamBridge;

    @Autowired
    private EoloPlantRepository eoloPlants;

    public List<EoloPlant> findAll() {
        return this.eoloPlants.findAll();
    }

    public EoloPlant create(EoloPlant eoloPlant){
        this.eoloPlants.save(eoloPlant);
        this.eoloPlantEvents.subscribe(e -> {
            System.out.println("EoloPlant: " + e);
            this.eoloPlantSink.tryEmitNext(e);
        });
        this.streamBridge.send("create", eoloPlant);
        return eoloPlant;
    }

    public EoloPlant update(EoloPlant eoloPlant) {
        this.eoloPlants.save(eoloPlant);
        this.eoloPlantSink.tryEmitNext(eoloPlant);
        return eoloPlant;
    }

    public EoloPlant findById(Long id) {
        return this.eoloPlants.findById(id).orElseThrow(
            () -> new IllegalArgumentException("EoloPlant not found"));    
        }

    public EoloPlant deleteById(Long id) {
        EoloPlant eoloPlant = this.findById(id);
        this.eoloPlants.delete(eoloPlant);
        this.eoloPlantSink.tryEmitNext(eoloPlant);
        return eoloPlant;
    }

    public Flux<EoloPlant> subscriptionEoloPlant(Long id) {
        return eoloPlantEvents
            .filter(e -> Objects.equals(e.getId(), id));
    }
}
