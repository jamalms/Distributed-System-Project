package grpc.temperature;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: temperature.proto")
public final class temperatureGrpc {

  private temperatureGrpc() {}

  public static final String SERVICE_NAME = "temperature";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.temperature.checkTemperature,
      grpc.temperature.temperatureAlarm> getSendTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendTemperature",
      requestType = grpc.temperature.checkTemperature.class,
      responseType = grpc.temperature.temperatureAlarm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.temperature.checkTemperature,
      grpc.temperature.temperatureAlarm> getSendTemperatureMethod() {
    io.grpc.MethodDescriptor<grpc.temperature.checkTemperature, grpc.temperature.temperatureAlarm> getSendTemperatureMethod;
    if ((getSendTemperatureMethod = temperatureGrpc.getSendTemperatureMethod) == null) {
      synchronized (temperatureGrpc.class) {
        if ((getSendTemperatureMethod = temperatureGrpc.getSendTemperatureMethod) == null) {
          temperatureGrpc.getSendTemperatureMethod = getSendTemperatureMethod = 
              io.grpc.MethodDescriptor.<grpc.temperature.checkTemperature, grpc.temperature.temperatureAlarm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "temperature", "sendTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.temperature.checkTemperature.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.temperature.temperatureAlarm.getDefaultInstance()))
                  .setSchemaDescriptor(new temperatureMethodDescriptorSupplier("sendTemperature"))
                  .build();
          }
        }
     }
     return getSendTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static temperatureStub newStub(io.grpc.Channel channel) {
    return new temperatureStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static temperatureBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new temperatureBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static temperatureFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new temperatureFutureStub(channel);
  }

  /**
   */
  public static abstract class temperatureImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendTemperature(grpc.temperature.checkTemperature request,
        io.grpc.stub.StreamObserver<grpc.temperature.temperatureAlarm> responseObserver) {
      asyncUnimplementedUnaryCall(getSendTemperatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.temperature.checkTemperature,
                grpc.temperature.temperatureAlarm>(
                  this, METHODID_SEND_TEMPERATURE)))
          .build();
    }
  }

  /**
   */
  public static final class temperatureStub extends io.grpc.stub.AbstractStub<temperatureStub> {
    private temperatureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private temperatureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected temperatureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new temperatureStub(channel, callOptions);
    }

    /**
     */
    public void sendTemperature(grpc.temperature.checkTemperature request,
        io.grpc.stub.StreamObserver<grpc.temperature.temperatureAlarm> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendTemperatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class temperatureBlockingStub extends io.grpc.stub.AbstractStub<temperatureBlockingStub> {
    private temperatureBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private temperatureBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected temperatureBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new temperatureBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.temperature.temperatureAlarm sendTemperature(grpc.temperature.checkTemperature request) {
      return blockingUnaryCall(
          getChannel(), getSendTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class temperatureFutureStub extends io.grpc.stub.AbstractStub<temperatureFutureStub> {
    private temperatureFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private temperatureFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected temperatureFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new temperatureFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.temperature.temperatureAlarm> sendTemperature(
        grpc.temperature.checkTemperature request) {
      return futureUnaryCall(
          getChannel().newCall(getSendTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_TEMPERATURE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final temperatureImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(temperatureImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_TEMPERATURE:
          serviceImpl.sendTemperature((grpc.temperature.checkTemperature) request,
              (io.grpc.stub.StreamObserver<grpc.temperature.temperatureAlarm>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class temperatureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    temperatureBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.temperature.TempRoomImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("temperature");
    }
  }

  private static final class temperatureFileDescriptorSupplier
      extends temperatureBaseDescriptorSupplier {
    temperatureFileDescriptorSupplier() {}
  }

  private static final class temperatureMethodDescriptorSupplier
      extends temperatureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    temperatureMethodDescriptorSupplier(String methodName) {
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
      synchronized (temperatureGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new temperatureFileDescriptorSupplier())
              .addMethod(getSendTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
