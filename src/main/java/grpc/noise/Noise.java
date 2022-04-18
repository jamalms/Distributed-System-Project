package grpc.noise;

import java.io.IOException;

import grpc.noise.Noise;
import grpc.noise.Noise.NoiseRoomImpl;
import grpc.noise.noiseGrpc.noiseImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Noise{
	
private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Noise ourServer = new Noise();
		ourServer.start();

	}
	
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		int port = 50052;
		
		server = ServerBuilder.forPort(port).addService(new NoiseRoomImpl()).build().start();
		System.out.println("Server running on port: " +port);
		server.awaitTermination();
	}
	
	static class NoiseRoomImpl extends noiseImplBase{

		@Override
		public void sound(checkNoise request, StreamObserver<noiseAlarm> responseObserver) {
			
			//Find out what was sent by the client
			float firstSound = request.getFirstSound();
			System.out.println("The Room voise is: " +firstSound);
			noiseAlarm.Builder response = noiseAlarm.newBuilder();
			
			if(firstSound > 45) {
				//return message
			response.setSoundAlarm("Noise Alarm Is Activated \n" + "Alerts, Human Presence, High noise intensity");
			}
			else { //return message
				response.setSoundAlarm("No noise is found");
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		
		}
		
		
		
	}
}