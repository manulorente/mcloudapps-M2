package mcloudapps.toposervice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import mcloudapps.toposervice.repository.TopographyRepository;
import mcloudapps.toposervice.model.Topography;

@Service
public class TopographyService {

    @Autowired
    private TopographyRepository topographies;

    public Optional<Topography> findById(String id) {
        return topographies.findById(id);
    }

    public void save(Topography topography) {
        topographies.save(topography);
    }
    
}
