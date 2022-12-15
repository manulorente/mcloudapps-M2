package mcloudapps.server.eoloplant.service;

import java.util.List;
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
    private EoloPlantRepository eoloPlantRepository;

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private TopoClient topoClient;

    public List<EoloPlant> findAll() {
        return this.eoloPlantRepository.findAll();
    }

    public EoloPlant save(EoloPlant eoloPlant) throws JsonProcessingException, InterruptedException, ExecutionException {
        String city = eoloPlant.getCity();
        String weather = getWeather(city);
        String landscape = getTopography(city);
        eoloPlant.setPlanning(city + "-" + weather + "-" + landscape);
        return this.eoloPlantRepository.save(eoloPlant);
    }

    public EoloPlant findById(Long id) {
        return this.eoloPlantRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("EoloPlant not found"));    
        }

    public EoloPlant deleteById(Long id) {
        EoloPlant eoloPlant = this.findById(id);
        this.eoloPlantRepository.delete(eoloPlant);
        return eoloPlant;
    }

    public String getWeather(String city) throws InterruptedException, ExecutionException{
        return weatherClient.getWeather(city);
    }

    public String getTopography(String city) throws JsonProcessingException {
        return topoClient.getTopography(city);
    }
}
