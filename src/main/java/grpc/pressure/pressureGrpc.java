package grpc.pressure;

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
    comments = "Source: pressure.proto")
public final class pressureGrpc {

  private pressureGrpc() {}

  public static final String SERVICE_NAME = "pressure";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.pressure.checkPressure,
      grpc.pressure.PressureAlarm> getRoomPressureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoomPressure",
      requestType = grpc.pressure.checkPressure.class,
      responseType = grpc.pressure.PressureAlarm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.pressure.checkPressure,
      grpc.pressure.PressureAlarm> getRoomPressureMethod() {
    io.grpc.MethodDescriptor<grpc.pressure.checkPressure, grpc.pressure.PressureAlarm> getRoomPressureMethod;
    if ((getRoomPressureMethod = pressureGrpc.getRoomPressureMethod) == null) {
      synchronized (pressureGrpc.class) {
        if ((getRoomPressureMethod = pressureGrpc.getRoomPressureMethod) == null) {
          pressureGrpc.getRoomPressureMethod = getRoomPressureMethod = 
              io.grpc.MethodDescriptor.<grpc.pressure.checkPressure, grpc.pressure.PressureAlarm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pressure", "RoomPressure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pressure.checkPressure.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pressure.PressureAlarm.getDefaultInstance()))
                  .setSchemaDescriptor(new pressureMethodDescriptorSupplier("RoomPressure"))
                  .build();
          }
        }
     }
     return getRoomPressureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static pressureStub newStub(io.grpc.Channel channel) {
    return new pressureStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static pressureBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new pressureBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static pressureFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new pressureFutureStub(channel);
  }

  /**
   */
  public static abstract class pressureImplBase implements io.grpc.BindableService {

    /**
     */
    public void roomPressure(grpc.pressure.checkPressure request,
        io.grpc.stub.StreamObserver<grpc.pressure.PressureAlarm> responseObserver) {
      asyncUnimplementedUnaryCall(getRoomPressureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRoomPressureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.pressure.checkPressure,
                grpc.pressure.PressureAlarm>(
                  this, METHODID_ROOM_PRESSURE)))
          .build();
    }
  }

  /**
   */
  public static final class pressureStub extends io.grpc.stub.AbstractStub<pressureStub> {
    private pressureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pressureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pressureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pressureStub(channel, callOptions);
    }

    /**
     */
    public void roomPressure(grpc.pressure.checkPressure request,
        io.grpc.stub.StreamObserver<grpc.pressure.PressureAlarm> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRoomPressureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class pressureBlockingStub extends io.grpc.stub.AbstractStub<pressureBlockingStub> {
    private pressureBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pressureBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pressureBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pressureBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.pressure.PressureAlarm roomPressure(grpc.pressure.checkPressure request) {
      return blockingUnaryCall(
          getChannel(), getRoomPressureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class pressureFutureStub extends io.grpc.stub.AbstractStub<pressureFutureStub> {
    private pressureFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pressureFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pressureFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pressureFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.pressure.PressureAlarm> roomPressure(
        grpc.pressure.checkPressure request) {
      return futureUnaryCall(
          getChannel().newCall(getRoomPressureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ROOM_PRESSURE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final pressureImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(pressureImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROOM_PRESSURE:
          serviceImpl.roomPressure((grpc.pressure.checkPressure) request,
              (io.grpc.stub.StreamObserver<grpc.pressure.PressureAlarm>) responseObserver);
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

  private static abstract class pressureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    pressureBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.pressure.PressureRoomImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("pressure");
    }
  }

  private static final class pressureFileDescriptorSupplier
      extends pressureBaseDescriptorSupplier {
    pressureFileDescriptorSupplier() {}
  }

  private static final class pressureMethodDescriptorSupplier
      extends pressureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    pressureMethodDescriptorSupplier(String methodName) {
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
      synchronized (pressureGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new pressureFileDescriptorSupplier())
              .addMethod(getRoomPressureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
