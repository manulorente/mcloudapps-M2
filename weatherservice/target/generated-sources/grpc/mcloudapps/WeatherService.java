package mcloudapps;

import io.quarkus.grpc.MutinyService;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: Weather.proto")
public interface WeatherService extends MutinyService {

    io.smallrye.mutiny.Uni<mcloudapps.WeatherResponse> getWeather(mcloudapps.WeatherRequest request);
}

