package mcloudapps.toposervice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import mcloudapps.toposervice.model.Topography;

public interface TopographyRepository extends ReactiveMongoRepository<Topography, String>{
    //Mono<Topography> findByIdIgnoreCase(String id);
}
