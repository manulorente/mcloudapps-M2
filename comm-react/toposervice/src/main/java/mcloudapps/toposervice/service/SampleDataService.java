package mcloudapps.toposervice.service;

import javax.annotation.PostConstruct;
import mcloudapps.toposervice.model.Topography;
import mcloudapps.toposervice.repository.TopographyRepository;
import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleDataService {
   
    @Autowired
    private TopographyRepository topographies;

    @PostConstruct
    public void init() {
        this.topographies.deleteAll();

        Flux<Topography> cities = Flux.just(
                new Topography("Madrid", "Flat"),
                new Topography("Barcelona", "Flat"),
                new Topography("Jaca", "Mountain"),
                new Topography("Andorra", "Mountain"),
                new Topography("Valencia", "Flat"),
                new Topography("Sevilla", "Mountain"),
                new Topography("Zaragoza", "Flat"),
                new Topography("Málaga", "Mountain"),
                new Topography("Murcia", "Flat"),
                new Topography("Palma", "Mountain"),
                new Topography("Bilbao", "Flat"),
                new Topography("Alicante", "Mountain"),
                new Topography("Córdoba", "Flat"),
                new Topography("Valladolid", "Mountain"),
                new Topography("Vigo", "Flat"),
                new Topography("Gijón", "Mountain"),
                new Topography("Vitoria", "Flat")
        );

        cities.flatMap(this.topographies::save).blockLast();
    }
}
