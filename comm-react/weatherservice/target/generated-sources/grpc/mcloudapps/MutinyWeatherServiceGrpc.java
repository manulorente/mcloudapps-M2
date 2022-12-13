package mcloudapps;

import static mcloudapps.WeatherServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: Weather.proto")
public final class MutinyWeatherServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyWeatherServiceGrpc() {
    }

    public static MutinyWeatherServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyWeatherServiceStub(channel);
    }

    public static class MutinyWeatherServiceStub extends io.grpc.stub.AbstractStub<MutinyWeatherServiceStub> implements io.quarkus.grpc.MutinyStub {

        private WeatherServiceGrpc.WeatherServiceStub delegateStub;

        private MutinyWeatherServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = WeatherServiceGrpc.newStub(channel);
        }

        private MutinyWeatherServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = WeatherServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyWeatherServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyWeatherServiceStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<mcloudapps.WeatherResponse> getWeather(mcloudapps.WeatherRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getWeather);
        }
    }

    public static abstract class WeatherServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public WeatherServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<mcloudapps.WeatherResponse> getWeather(mcloudapps.WeatherRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(mcloudapps.WeatherServiceGrpc.getGetWeatherMethod(), asyncUnaryCall(new MethodHandlers<mcloudapps.WeatherRequest, mcloudapps.WeatherResponse>(this, METHODID_GET_WEATHER, compression))).build();
        }
    }

    private static final int METHODID_GET_WEATHER = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final WeatherServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(WeatherServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_WEATHER:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((mcloudapps.WeatherRequest) request, (io.grpc.stub.StreamObserver<mcloudapps.WeatherResponse>) responseObserver, compression, serviceImpl::getWeather);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}

