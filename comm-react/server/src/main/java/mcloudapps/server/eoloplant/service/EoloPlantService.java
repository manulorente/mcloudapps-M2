package mcloudapps.server.eoloplant.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// import io.grpc.ManagedChannel;
// import io.grpc.ManagedChannelBuilder;
// import io.grpc.stub.*;

// import net.devh.boot.grpc.client.inject.GrpcClient;

import mcloudapps.server.eoloplant.model.EoloPlant;
import mcloudapps.server.eoloplant.repository.EoloPlantRepository;
// 
// import java.util.concurrent.CompletableFuture;

// import mcloudapps.WeatherRequest;
// import mcloudapps.WeatherResponse;


@Service
public class EoloPlantService {

    @Autowired
    private EoloPlantRepository eoloPlantRepository;

    //@GrpcClient("WeatherServiceGrpc")
    //private WeatherServiceBlockingStub weatherServerClient;

    public List<EoloPlant> findAll() {
        return this.eoloPlantRepository.findAll();
    }

    public EoloPlant save(EoloPlant eoloPlant) throws JsonProcessingException {
        String city = eoloPlant.getCity();
        String weather = getWeather(city);
        String landscape = getTopography(city);
        eoloPlant.setPlanning(city + "-" + weather + "-" + landscape);
        return this.eoloPlantRepository.save(eoloPlant);
    }

    public EoloPlant findById(Long id) {
        return this.eoloPlantRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("EoloPlant not found"));    
        }

    public EoloPlant deleteById(Long id) {
        EoloPlant eoloPlant = this.findById(id);
        this.eoloPlantRepository.delete(eoloPlant);
        return eoloPlant;
    }

    // FIXME: Cannot connect to Grpc service
    @Async
    public String getWeather(String city) {
        if (city.matches("^[aeiouAEIOU].*")) return "Rainny";
        return "Sunny";

        // ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9001)
        // .usePlaintext()
        // .build();

        // WeatherStub weatherServiceAsyncStub = WeatherGrpc.newStub(channel);
        // WeatherRequest weatherRequest = WeatherRequest.newBuilder().setCity(city).build();

        // WeatherRequest request = WeatherRequest.newBuilder()
        //         .setCity(city)
        //         .build();

        // return weatherServiceAsyncStub.getWeather(weatherRequest).onNext(weatherRequest,
        //     new StreamObserver<WeatherResponse>() {
        //         @Override
        //         public void onNext(WeatherResponse value) {
        //             System.out.println("Received weather " + value.getWeather());
        //             return value.getWeather();
        //         }

        //         @Override
        //         public void onError(Throwable t) {
        //             System.out.println("Error occurred, cause " + t.getMessage());
                    
        //         }
        //         @Override
        //         public void onCompleted() {
        //             System.out.println("Stream completed");
                    
        //         }
        //     }
        // ).onCompleted().toString();

        //WeatherResponse response = this.weatherServerClient.getWeather(request.);

        //return CompletableFuture.completedFuture(response.getWeather()).join();
    }

    @Async
    public String getTopography(String city) throws JsonProcessingException{
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/v1/topographicdetails/" + city;
        String topography = restTemplate.getForObject(url, String.class);
        Map<String,Object> map = new ObjectMapper().readValue(topography, Map.class);
        return map.get("landscape").toString();
    }
    
}
