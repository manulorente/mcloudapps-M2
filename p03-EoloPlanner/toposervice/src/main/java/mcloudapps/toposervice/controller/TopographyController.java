package mcloudapps.toposervice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.Duration;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mcloudapps.toposervice.dto.TopographyDTO;
import mcloudapps.toposervice.model.Topography;
import mcloudapps.toposervice.service.TopographyService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/topographicdetails")
public class TopographyController {
    
    @Autowired
    private TopographyService topographies;

    @GetMapping("/{city}")
    public Mono<TopographyDTO> getTopography(@PathVariable String city) {
        return topographies.findById(city)
            .switchIfEmpty(Mono.error(new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Topography of " + city + " not found")))
            .delayElement(Duration.ofSeconds(new Random().nextInt(3) + 1))
            .map(this::convertToDTO);
    }

    private TopographyDTO convertToDTO(Topography topography) {
        return new TopographyDTO(topography.getId(), topography.getLandscape());
    }

}
