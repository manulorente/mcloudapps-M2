package mcloudapps;

import java.util.function.BiFunction;
import io.quarkus.grpc.MutinyClient;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: Weather.proto")
public class WeatherServiceClient implements WeatherService, MutinyClient<MutinyWeatherServiceGrpc.MutinyWeatherServiceStub> {

    private final MutinyWeatherServiceGrpc.MutinyWeatherServiceStub stub;

    public WeatherServiceClient(String name, io.grpc.Channel channel, BiFunction<String, MutinyWeatherServiceGrpc.MutinyWeatherServiceStub, MutinyWeatherServiceGrpc.MutinyWeatherServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyWeatherServiceGrpc.newMutinyStub(channel));
    }

    private WeatherServiceClient(MutinyWeatherServiceGrpc.MutinyWeatherServiceStub stub) {
        this.stub = stub;
    }

    public WeatherServiceClient newInstanceWithStub(MutinyWeatherServiceGrpc.MutinyWeatherServiceStub stub) {
        return new WeatherServiceClient(stub);
    }

    @Override
    public MutinyWeatherServiceGrpc.MutinyWeatherServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<mcloudapps.WeatherResponse> getWeather(mcloudapps.WeatherRequest request) {
        return stub.getWeather(request);
    }
}

