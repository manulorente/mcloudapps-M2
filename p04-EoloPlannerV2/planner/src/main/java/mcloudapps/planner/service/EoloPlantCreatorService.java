package mcloudapps.planner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import mcloudapps.planner.model.EoloPlant;
import mcloudapps.planner.client.TopoClient;
import mcloudapps.planner.client.WeatherClient;

@Service
public class EoloPlantCreatorService {

    private Logger log = LoggerFactory.getLogger(EoloPlantCreatorService.class);

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private TopoClient topoClient;

    @Autowired
    private StreamBridge streamBridge;
    
    public void create(EoloPlant eoloPlant) throws JsonProcessingException, InterruptedException, ExecutionException {
        String city = eoloPlant.getCity();
        eoloPlant.setProgress(0);
        sendUpdate(eoloPlant);
        CompletableFuture<String> weather = getWeather(city);     
        eoloPlant.setProgress(25);
        sendUpdate(eoloPlant);   
        CompletableFuture<String> landscape = getTopography(city);
        eoloPlant.setProgress(50);
        sendUpdate(eoloPlant);        
        CompletableFuture.allOf(weather, landscape).get();
        eoloPlant.setProgress(75);
        sendUpdate(eoloPlant);
        eoloPlant.setPlanning(city + "-" + weather.get() + "-" + landscape.get());
        simulateProcessWaiting();
        eoloPlant.setCompleted(true);
        eoloPlant.setProgress(100);
        sendUpdate(eoloPlant);
    }

    private CompletableFuture<String> getWeather(String city) throws InterruptedException, ExecutionException {
        return this.weatherClient.getWeather(city).thenApply(w -> {
            log.info("Weather: " + w);
            return w;
        });
    }

    private CompletableFuture<String> getTopography(String city) throws JsonProcessingException {
        return this.topoClient.getTopography(city).thenApply(t -> {
            log.info("Topography: " + t);
            return t;
        });
    }

    private void simulateProcessWaiting() throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(3) + 1);
    }

    private void sendUpdate(EoloPlant eoloPlant) throws JsonProcessingException {
        streamBridge.send("progress", eoloPlant);
    }

}
