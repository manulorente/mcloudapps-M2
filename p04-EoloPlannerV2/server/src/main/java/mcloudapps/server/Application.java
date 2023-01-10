package mcloudapps.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.service.EoloPlantService;

@SpringBootApplication
@EnableAsync
public class Application {

	@Autowired
	private EoloPlantService eoloPlantService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    Consumer<EoloPlant> progressconsumer() {
        return eoloPlant -> {
            System.out.println("Progress: " + eoloPlant.getCity() + " " + eoloPlant.getProgress());
            try {
                this.eoloPlantService.update(eoloPlant);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

}
