package mcloudapps.server.eoloplant.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import mcloudapps.server.eoloplant.client.TopoClient;
import mcloudapps.server.eoloplant.client.WeatherClient;
import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.repository.EoloPlantRepository;

@Service
public class EoloPlantService {

    @Autowired
    private EoloPlantRepository eoloPlants;

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private TopoClient topoClient;

    public List<EoloPlant> findAll() {
        return this.eoloPlants.findAll();
    }

    public EoloPlant createEoloPlant(EoloPlant eoloPlant) throws JsonProcessingException, InterruptedException, ExecutionException {
        String city = eoloPlant.getCity();
        CompletableFuture<String> weather = getWeather(city);
        CompletableFuture<String> landscape = getTopography(city);
        CompletableFuture.allOf(weather, landscape).get();
        eoloPlant.setPlanning(city + "-" + weather.get() + "-" + landscape.get());
        return this.eoloPlants.save(eoloPlant);
    }

    public EoloPlant findById(Long id) {
        return this.eoloPlants.findById(id).orElseThrow(
            () -> new IllegalArgumentException("EoloPlant not found"));    
        }

    public EoloPlant deleteById(Long id) {
        EoloPlant eoloPlant = this.findById(id);
        this.eoloPlants.delete(eoloPlant);
        return eoloPlant;
    }

    private CompletableFuture<String> getWeather(String city) throws InterruptedException, ExecutionException {
        return this.weatherClient.getWeather(city).thenApply(w -> {
            System.out.println("Weather: " + w);
            return w;
        });
    }

    private CompletableFuture<String> getTopography(String city) throws JsonProcessingException {
        return this.topoClient.getTopography(city).thenApply(t -> {
            System.out.println("Topography: " + t);
            return t;
        });
    }
}
