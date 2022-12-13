package mcloudapps;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class WeatherGrpcService implements WeatherService {

    @Override
    public Uni<WeatherResponse> getWeather(WeatherRequest request) {
        System.out.println("Received request from " + request);
        String weatherType = startWithVowel(request.getCity()) ? "Rainny" : "Sunny";

        WeatherResponse response = WeatherResponse.newBuilder()
                .setCity(request.getCity())
                .setWeather(weatherType)
                .build();
        
        return Uni.createFrom().item(response);
    }

    private boolean startWithVowel(String city) {
        return city.toLowerCase().startsWith("a") || city.toLowerCase().startsWith("e") || city.toLowerCase().startsWith("i")
                || city.toLowerCase().startsWith("o") || city.toLowerCase().startsWith("u");
    }
}
