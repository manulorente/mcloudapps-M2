package mcloudapps.toposervice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

import mcloudapps.toposervice.repository.TopographyRepository;
import mcloudapps.toposervice.model.Topography;

@Service
public class TopographyService {

    @Autowired
    private TopographyRepository topographies;

    public Mono<Topography> findById(String id) {
        return topographies.findById(id)
            .switchIfEmpty(Mono.error(new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Topography of " + id + " not found")));
    }

    public void save(Topography topography) {
        topographies.save(topography);
    }
    
}
