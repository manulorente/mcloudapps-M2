package mcloudapps.server.subscriber;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.util.concurrent.Queues;

import mcloudapps.server.eoloplant.model.EoloPlant;

@Configuration
public class SubscriptionConfig {

  @Bean
  public Many<EoloPlant> eoloPlantSink() {
    return Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
  }

  @Bean
  public Flux<EoloPlant> eoloPlantFlux(Many<EoloPlant> eoloPlantSink) {
    return eoloPlantSink.asFlux();
  }

}
