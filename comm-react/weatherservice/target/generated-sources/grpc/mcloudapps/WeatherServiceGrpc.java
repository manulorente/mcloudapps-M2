package mcloudapps;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.quarkus.grpc.common.Generated(value = "by gRPC proto compiler (version 1.50.2)", comments = "Source: Weather.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WeatherServiceGrpc {

    private WeatherServiceGrpc() {
    }

    public static final String SERVICE_NAME = "weather.WeatherService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<mcloudapps.WeatherRequest, mcloudapps.WeatherResponse> getGetWeatherMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "getWeather", requestType = mcloudapps.WeatherRequest.class, responseType = mcloudapps.WeatherResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<mcloudapps.WeatherRequest, mcloudapps.WeatherResponse> getGetWeatherMethod() {
        io.grpc.MethodDescriptor<mcloudapps.WeatherRequest, mcloudapps.WeatherResponse> getGetWeatherMethod;
        if ((getGetWeatherMethod = WeatherServiceGrpc.getGetWeatherMethod) == null) {
            synchronized (WeatherServiceGrpc.class) {
                if ((getGetWeatherMethod = WeatherServiceGrpc.getGetWeatherMethod) == null) {
                    WeatherServiceGrpc.getGetWeatherMethod = getGetWeatherMethod = io.grpc.MethodDescriptor.<mcloudapps.WeatherRequest, mcloudapps.WeatherResponse>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "getWeather")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(mcloudapps.WeatherRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(mcloudapps.WeatherResponse.getDefaultInstance())).setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("getWeather")).build();
                }
            }
        }
        return getGetWeatherMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static WeatherServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<WeatherServiceStub> factory = new io.grpc.stub.AbstractStub.StubFactory<WeatherServiceStub>() {

            @java.lang.Override
            public WeatherServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new WeatherServiceStub(channel, callOptions);
            }
        };
        return WeatherServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static WeatherServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<WeatherServiceBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<WeatherServiceBlockingStub>() {

            @java.lang.Override
            public WeatherServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new WeatherServiceBlockingStub(channel, callOptions);
            }
        };
        return WeatherServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static WeatherServiceFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<WeatherServiceFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<WeatherServiceFutureStub>() {

            @java.lang.Override
            public WeatherServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new WeatherServiceFutureStub(channel, callOptions);
            }
        };
        return WeatherServiceFutureStub.newStub(factory, channel);
    }

    /**
     */
    public static abstract class WeatherServiceImplBase implements io.grpc.BindableService {

        /**
         */
        public void getWeather(mcloudapps.WeatherRequest request, io.grpc.stub.StreamObserver<mcloudapps.WeatherResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherMethod(), responseObserver);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getGetWeatherMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<mcloudapps.WeatherRequest, mcloudapps.WeatherResponse>(this, METHODID_GET_WEATHER))).build();
        }
    }

    /**
     */
    public static class WeatherServiceStub extends io.grpc.stub.AbstractAsyncStub<WeatherServiceStub> {

        private WeatherServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected WeatherServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WeatherServiceStub(channel, callOptions);
        }

        /**
         */
        public void getWeather(mcloudapps.WeatherRequest request, io.grpc.stub.StreamObserver<mcloudapps.WeatherResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGetWeatherMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static class WeatherServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WeatherServiceBlockingStub> {

        private WeatherServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected WeatherServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WeatherServiceBlockingStub(channel, callOptions);
        }

        /**
         */
        public mcloudapps.WeatherResponse getWeather(mcloudapps.WeatherRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGetWeatherMethod(), getCallOptions(), request);
        }
    }

    /**
     */
    public static class WeatherServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WeatherServiceFutureStub> {

        private WeatherServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected WeatherServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WeatherServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<mcloudapps.WeatherResponse> getWeather(mcloudapps.WeatherRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGetWeatherMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_GET_WEATHER = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final WeatherServiceImplBase serviceImpl;

        private final int methodId;

        MethodHandlers(WeatherServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_WEATHER:
                    serviceImpl.getWeather((mcloudapps.WeatherRequest) request, (io.grpc.stub.StreamObserver<mcloudapps.WeatherResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class WeatherServiceBaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        WeatherServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return mcloudapps.Weather.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("WeatherService");
        }
    }

    private static final class WeatherServiceFileDescriptorSupplier extends WeatherServiceBaseDescriptorSupplier {

        WeatherServiceFileDescriptorSupplier() {
        }
    }

    private static final class WeatherServiceMethodDescriptorSupplier extends WeatherServiceBaseDescriptorSupplier implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final String methodName;

        WeatherServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (WeatherServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new WeatherServiceFileDescriptorSupplier()).addMethod(getGetWeatherMethod()).build();
                }
            }
        }
        return result;
    }
}

