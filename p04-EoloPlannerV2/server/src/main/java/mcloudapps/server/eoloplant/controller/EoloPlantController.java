package mcloudapps.server.eoloplant.controller;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import org.reactivestreams.Publisher;

import com.fasterxml.jackson.core.JsonProcessingException;

import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.service.EoloPlantService;

@Controller
public class EoloPlantController {

    @Autowired
    private EoloPlantService eoloPlantService;

    @QueryMapping
    public List<EoloPlant> eoloPlants() {
        return this.eoloPlantService.findAll();
    }

    @QueryMapping
    public EoloPlant eoloPlant(@Argument Long id) {
        return this.eoloPlantService.findById(id);    
    }

    @MutationMapping
    public EoloPlant createEoloPlant(@Argument EoloPlant eoloPlant) throws JsonProcessingException, InterruptedException, ExecutionException {
        return this.eoloPlantService.create(eoloPlant);
    }

    @MutationMapping
    public EoloPlant updateEoloPlant(@Argument EoloPlant eoloPlant) throws JsonProcessingException {
        return this.eoloPlantService.update(eoloPlant);
    }

    @MutationMapping
    public void deleteEoloPlant(@Argument Long id) throws JsonProcessingException {
        this.eoloPlantService.deleteById(id);
    }

    /* 
    @SubscriptionMapping
    public Publisher<List<EoloPlant>> subscriptionEoloPlants() {
        return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            List<EoloPlant> people = eoloPlantService.findAll();
            subscriber.onNext(people);
        }, 0, 1, TimeUnit.SECONDS);
    }
    @SubscriptionMapping
    public Publisher<EoloPlant> subscriptionEoloPlant(@Argument Long id) {
        return eoloPlantService.subscriptionEoloPlant(id);
    }
    */
}
