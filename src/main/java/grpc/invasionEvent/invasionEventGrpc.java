package grpc.invasionEvent;

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
    comments = "Source: invasionEvent.proto")
public final class invasionEventGrpc {

  private invasionEventGrpc() {}

  public static final String SERVICE_NAME = "invasionEvent";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.invasionEvent.checkRoomStatus,
      grpc.invasionEvent.invasionAlarm> getRoomStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "roomStatus",
      requestType = grpc.invasionEvent.checkRoomStatus.class,
      responseType = grpc.invasionEvent.invasionAlarm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.invasionEvent.checkRoomStatus,
      grpc.invasionEvent.invasionAlarm> getRoomStatusMethod() {
    io.grpc.MethodDescriptor<grpc.invasionEvent.checkRoomStatus, grpc.invasionEvent.invasionAlarm> getRoomStatusMethod;
    if ((getRoomStatusMethod = invasionEventGrpc.getRoomStatusMethod) == null) {
      synchronized (invasionEventGrpc.class) {
        if ((getRoomStatusMethod = invasionEventGrpc.getRoomStatusMethod) == null) {
          invasionEventGrpc.getRoomStatusMethod = getRoomStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.invasionEvent.checkRoomStatus, grpc.invasionEvent.invasionAlarm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "invasionEvent", "roomStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.invasionEvent.checkRoomStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.invasionEvent.invasionAlarm.getDefaultInstance()))
                  .setSchemaDescriptor(new invasionEventMethodDescriptorSupplier("roomStatus"))
                  .build();
          }
        }
     }
     return getRoomStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static invasionEventStub newStub(io.grpc.Channel channel) {
    return new invasionEventStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static invasionEventBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new invasionEventBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static invasionEventFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new invasionEventFutureStub(channel);
  }

  /**
   */
  public static abstract class invasionEventImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.invasionEvent.checkRoomStatus> roomStatus(
        io.grpc.stub.StreamObserver<grpc.invasionEvent.invasionAlarm> responseObserver) {
      return asyncUnimplementedStreamingCall(getRoomStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRoomStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.invasionEvent.checkRoomStatus,
                grpc.invasionEvent.invasionAlarm>(
                  this, METHODID_ROOM_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class invasionEventStub extends io.grpc.stub.AbstractStub<invasionEventStub> {
    private invasionEventStub(io.grpc.Channel channel) {
      super(channel);
    }

    private invasionEventStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected invasionEventStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new invasionEventStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.invasionEvent.checkRoomStatus> roomStatus(
        io.grpc.stub.StreamObserver<grpc.invasionEvent.invasionAlarm> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRoomStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class invasionEventBlockingStub extends io.grpc.stub.AbstractStub<invasionEventBlockingStub> {
    private invasionEventBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private invasionEventBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected invasionEventBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new invasionEventBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class invasionEventFutureStub extends io.grpc.stub.AbstractStub<invasionEventFutureStub> {
    private invasionEventFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private invasionEventFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected invasionEventFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new invasionEventFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ROOM_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final invasionEventImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(invasionEventImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROOM_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.roomStatus(
              (io.grpc.stub.StreamObserver<grpc.invasionEvent.invasionAlarm>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class invasionEventBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    invasionEventBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.invasionEvent.InvasionEventImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("invasionEvent");
    }
  }

  private static final class invasionEventFileDescriptorSupplier
      extends invasionEventBaseDescriptorSupplier {
    invasionEventFileDescriptorSupplier() {}
  }

  private static final class invasionEventMethodDescriptorSupplier
      extends invasionEventBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    invasionEventMethodDescriptorSupplier(String methodName) {
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
      synchronized (invasionEventGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new invasionEventFileDescriptorSupplier())
              .addMethod(getRoomStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
