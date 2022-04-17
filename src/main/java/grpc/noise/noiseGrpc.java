package grpc.noise;

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
    comments = "Source: noise.proto")
public final class noiseGrpc {

  private noiseGrpc() {}

  public static final String SERVICE_NAME = "noise";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.noise.checkNoise,
      grpc.noise.noiseAlarm> getSoundMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sound",
      requestType = grpc.noise.checkNoise.class,
      responseType = grpc.noise.noiseAlarm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.noise.checkNoise,
      grpc.noise.noiseAlarm> getSoundMethod() {
    io.grpc.MethodDescriptor<grpc.noise.checkNoise, grpc.noise.noiseAlarm> getSoundMethod;
    if ((getSoundMethod = noiseGrpc.getSoundMethod) == null) {
      synchronized (noiseGrpc.class) {
        if ((getSoundMethod = noiseGrpc.getSoundMethod) == null) {
          noiseGrpc.getSoundMethod = getSoundMethod = 
              io.grpc.MethodDescriptor.<grpc.noise.checkNoise, grpc.noise.noiseAlarm>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "noise", "Sound"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.noise.checkNoise.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.noise.noiseAlarm.getDefaultInstance()))
                  .setSchemaDescriptor(new noiseMethodDescriptorSupplier("Sound"))
                  .build();
          }
        }
     }
     return getSoundMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static noiseStub newStub(io.grpc.Channel channel) {
    return new noiseStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static noiseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new noiseBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static noiseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new noiseFutureStub(channel);
  }

  /**
   */
  public static abstract class noiseImplBase implements io.grpc.BindableService {

    /**
     */
    public void sound(grpc.noise.checkNoise request,
        io.grpc.stub.StreamObserver<grpc.noise.noiseAlarm> responseObserver) {
      asyncUnimplementedUnaryCall(getSoundMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSoundMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.noise.checkNoise,
                grpc.noise.noiseAlarm>(
                  this, METHODID_SOUND)))
          .build();
    }
  }

  /**
   */
  public static final class noiseStub extends io.grpc.stub.AbstractStub<noiseStub> {
    private noiseStub(io.grpc.Channel channel) {
      super(channel);
    }

    private noiseStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected noiseStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new noiseStub(channel, callOptions);
    }

    /**
     */
    public void sound(grpc.noise.checkNoise request,
        io.grpc.stub.StreamObserver<grpc.noise.noiseAlarm> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSoundMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class noiseBlockingStub extends io.grpc.stub.AbstractStub<noiseBlockingStub> {
    private noiseBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private noiseBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected noiseBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new noiseBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.noise.noiseAlarm sound(grpc.noise.checkNoise request) {
      return blockingUnaryCall(
          getChannel(), getSoundMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class noiseFutureStub extends io.grpc.stub.AbstractStub<noiseFutureStub> {
    private noiseFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private noiseFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected noiseFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new noiseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.noise.noiseAlarm> sound(
        grpc.noise.checkNoise request) {
      return futureUnaryCall(
          getChannel().newCall(getSoundMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SOUND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final noiseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(noiseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SOUND:
          serviceImpl.sound((grpc.noise.checkNoise) request,
              (io.grpc.stub.StreamObserver<grpc.noise.noiseAlarm>) responseObserver);
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

  private static abstract class noiseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    noiseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.noise.NoiseRoomImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("noise");
    }
  }

  private static final class noiseFileDescriptorSupplier
      extends noiseBaseDescriptorSupplier {
    noiseFileDescriptorSupplier() {}
  }

  private static final class noiseMethodDescriptorSupplier
      extends noiseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    noiseMethodDescriptorSupplier(String methodName) {
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
      synchronized (noiseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new noiseFileDescriptorSupplier())
              .addMethod(getSoundMethod())
              .build();
        }
      }
    }
    return result;
  }
}
