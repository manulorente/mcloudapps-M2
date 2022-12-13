package mcloudapps.toposervice.service;

import jakarta.annotation.PostConstruct;
import mcloudapps.toposervice.model.Topography;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleDataService {
   
    @Autowired
    private TopographyService topographies;

    @PostConstruct
    public void init() {
        topographies.save(new Topography("Paris", "Flat"));
        topographies.save(new Topography("London", "Hilly"));
        topographies.save(new Topography("New York", "Mountainous"));
        topographies.save(new Topography("Tokyo", "Flat"));
    }
}
