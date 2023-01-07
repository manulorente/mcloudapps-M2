package mcloudapps.server.eoloplant.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.service.EoloPlantService;

@Controller
public class EoloPlantController {

    @Autowired
    private EoloPlantService eoloPlants;

    @QueryMapping
    public List<EoloPlant> eoloPlants() {
        return this.eoloPlants.findAll();
    }

    @QueryMapping
    public EoloPlant eoloPlant(@Argument Long id) {
        return this.eoloPlants.findById(id);
    }

    @MutationMapping
    public EoloPlant createEoloPlant(@Argument EoloPlant eoloPlant) throws JsonProcessingException, InterruptedException, ExecutionException {
        return this.eoloPlants.createEoloPlant(eoloPlant);
    }

    @MutationMapping
    public void deleteEoloPlant(@Argument Long id) throws JsonProcessingException {
        this.eoloPlants.deleteById(id);
    }
    
}
