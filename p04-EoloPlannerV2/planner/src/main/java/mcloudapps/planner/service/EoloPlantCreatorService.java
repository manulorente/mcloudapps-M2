package mcloudapps.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.Random;

import mcloudapps.planner.model.EoloPlant;
import mcloudapps.planner.client.TopoClient;
import mcloudapps.planner.client.WeatherClient;

@Service
public class EoloPlantCreatorService {

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private TopoClient topoClient;

    @Autowired
    private StreamBridge streamBridge;
    
    @Async
    public void create(EoloPlant eoloPlant) throws JsonProcessingException, InterruptedException, ExecutionException {
        String city = eoloPlant.getCity();
        eoloPlant.setProgress(0);
        sendUpdate(eoloPlant);
        CompletableFuture<String> weather = getWeather(city);
        CompletableFuture<String> landscape = getTopography(city);
        eoloPlant.setProgress(25);
        sendUpdate(eoloPlant);        
        simulateProcessWaiting();
        CompletableFuture.allOf(weather, landscape).get();
        eoloPlant.setProgress(75);
        sendUpdate(eoloPlant);
        eoloPlant.setPlanning(city + "-" + weather.get() + "-" + landscape.get());
        eoloPlant.setCompleted(true);
        eoloPlant.setProgress(100);
        sendUpdate(eoloPlant);
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

    private void simulateProcessWaiting() throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextLong(4));
    }
    
    private void sendUpdate(EoloPlant eoloPlant) throws JsonProcessingException {
        streamBridge.send("progress", eoloPlant);
    }

}
