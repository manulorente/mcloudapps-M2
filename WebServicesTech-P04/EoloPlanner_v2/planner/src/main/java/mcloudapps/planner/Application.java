package mcloudapps.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import mcloudapps.planner.model.EoloPlant;
import mcloudapps.planner.service.EoloPlantCreatorService;

@SpringBootApplication
@EnableAsync
public class Application {

	@Autowired
	private EoloPlantCreatorService eoloPlantCreatorService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Consumer<EoloPlant> createconsumer(){
		return eoloPlant -> {
			System.out.println("Create: " + eoloPlant.getCity());
			try {
            	this.eoloPlantCreatorService.create(eoloPlant);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		};
    }

}
