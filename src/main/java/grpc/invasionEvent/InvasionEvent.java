package grpc.invasionEvent;

import java.io.IOException;

import grpc.invasionEvent.invasionEventGrpc.invasionEventImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class InvasionEvent{
	
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		InvasionEvent ourServer = new InvasionEvent();
		ourServer.start();
		
	}
	void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		int port = 50054;
		
		server = ServerBuilder.forPort(port).addService(new InvasionEventImpl()).build().start();
		System.out.println("Server running on port: " +port);
		server.awaitTermination();
	}
	
	static class InvasionEventImpl extends invasionEventImplBase {

		public void RoomStatus(checkRoomStatus request, StreamObserver<invasionAlarm> responseObserver) {
			invasionAlarm.Builder response = invasionAlarm.newBuilder();
			//Noise 
			float firstRoomSound = request.getFirstRoomSound();
			System.out.println("The Sound Intensity is: " +firstRoomSound);
			
			
			if(firstRoomSound >= 45) {
				//return message
			response.setSoundIntensityAlarm("Noise Alarm Is Activated \n" + "Alerts, Human Presence, High noise intensity");
			}
			else { //return message
				response.setSoundIntensityAlarm("No noise is found");
			}
			
			//Temperature
			float firstRoomTemperature = request.getFirstRoomTemperature();
			System.out.println("The Temperature is: " +firstRoomTemperature);
			//invasionAlarm.Builder response = invasionAlarm.newBuilder();
			
			if(firstRoomTemperature > 25) {
				//return message
			response.setObjectTempAlarm("Temperature Alarm Is Activated. Alerts, Human Presence");
			}
			else { //return message
				response.setObjectTempAlarm("The temmperature is normal");
			}
			
			//Room Pressure
			float firstRoomPressure = request.getFirstRoomPressure();
			System.out.println("The Room Pressure is: " +firstRoomPressure);
			//invasionAlarm.Builder response = invasionAlarm.newBuilder();
			
			if(firstRoomPressure  != 63.21) {
				//return message
			response.setAirPressureAlarm("Pressure Alarm Is Activated \n" + "Alerts, Air Pressure out of the range");
			}
			else { //return message
				response.setAirPressureAlarm("The room pressure is NORMAL");
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
			
			
		}///for RoomStatus
		
		
		
		
	}
	}
