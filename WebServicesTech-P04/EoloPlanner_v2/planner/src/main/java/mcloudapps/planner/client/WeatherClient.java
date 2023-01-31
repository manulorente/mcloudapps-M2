package mcloudapps.planner.client;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import mcloudapps.planner.grpc.WeatherRequest;
import mcloudapps.planner.grpc.WeatherResponse;
import mcloudapps.planner.grpc.WeatherServiceGrpc;

@Service
public class WeatherClient {
    
    private static final String WEATHER_HOST = "localhost";
    private static final int WEATHER_PORT = 9090;

    @Async
    public CompletableFuture<String> getWeather(String city) throws InterruptedException, ExecutionException{
        ManagedChannel channel = ManagedChannelBuilder.forAddress(WEATHER_HOST, WEATHER_PORT)
        .usePlaintext()
        .build();

        WeatherServiceGrpc.WeatherServiceBlockingStub client = WeatherServiceGrpc.newBlockingStub(channel);

        WeatherRequest request = WeatherRequest.newBuilder()
                .setCity(city)
                .build();

        WeatherResponse response = client.getWeather(request);

        channel.shutdown();

        return CompletableFuture.completedFuture(response.getWeather());
    }

}
