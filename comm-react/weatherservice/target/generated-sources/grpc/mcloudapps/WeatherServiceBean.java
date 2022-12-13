package mcloudapps;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: Weather.proto")
public class WeatherServiceBean extends MutinyWeatherServiceGrpc.WeatherServiceImplBase implements BindableService, MutinyBean {

    private final WeatherService delegate;

    WeatherServiceBean(@GrpcService WeatherService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<mcloudapps.WeatherResponse> getWeather(mcloudapps.WeatherRequest request) {
        try {
            return delegate.getWeather(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}

