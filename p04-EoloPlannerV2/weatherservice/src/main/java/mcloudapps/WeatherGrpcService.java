package mcloudapps;

import java.time.Duration;
import java.util.Random;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

import mcloudapps.planner.grpc.WeatherResponse;
import mcloudapps.planner.grpc.WeatherService;
import mcloudapps.planner.grpc.WeatherRequest;

@GrpcService
public class WeatherGrpcService implements WeatherService {

    @Override
    public Uni<WeatherResponse> getWeather(WeatherRequest request) {
        
        String city = request.getCity();

        String weather = city.matches("^[aeiou].*") ? "Rainy" : "Sunny";

        return Uni.createFrom().item(WeatherResponse.newBuilder().setWeather(weather).setCity(city).build())
                .onItem().delayIt().by(Duration.ofMillis(1000 + new Random().nextInt(2000)));
    }
}
