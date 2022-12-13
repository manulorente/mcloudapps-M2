package mcloudapps.toposervice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mcloudapps.toposervice.model.Topography;

public interface TopographyRepository extends MongoRepository<Topography, String>{
    //Mono<Topography> findByIdIgnoreCase(String id);
}
